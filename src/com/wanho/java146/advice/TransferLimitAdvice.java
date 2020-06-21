package com.wanho.java146.advice;


import com.wanho.java146.dao.CustomerDAO;
import com.wanho.java146.dao.TransferLimitDAO;
import com.wanho.java146.pojo.Customer;
import com.wanho.java146.pojo.MoneyLimit;
import com.wanho.java146.pojo.TransferLog;
import com.wanho.java146.utils.JDBCutil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;

@Component
@Aspect
public class TransferLimitAdvice implements Ordered {

    @Autowired
    private TransferLimitDAO transferLimitDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Pointcut("execution(* com.wanho.java146.service.impl.CustomerServiceImpl.transfer(..)))")
    private void good(){}

    @Around("good()")
    public Object doTransferLimit(ProceedingJoinPoint pjp) throws SQLException {
        Object[] pjpArgs = pjp.getArgs();
        TransferLog transferLog = new TransferLog();

        //首先确定该原账号存不存在
        Customer customer = customerDAO.selectById((String) pjpArgs[0]);

        if(customer!=null){
            transferLog.setSid((String) pjpArgs[0]);
            transferLog.setMoney((Float) pjpArgs[2]);
            transferLog.setEndTime(new Date());
            transferLog.setStatus("SUCCESSFUL_TRANSFER");
            System.out.println(transferLog);
            //如果这24小时之内没有转账记录，得到的moneyLimit.getMoney()必定为null，将其手动赋值为0
            MoneyLimit moneyLimit = transferLimitDAO.selectTransferLimit(transferLog);
            if(moneyLimit .getMoney()== null){
                moneyLimit.setMoney(0f);
            }
            System.out.println(moneyLimit);
            if (moneyLimit.getMoney() <= 20000f) {
                if (moneyLimit.getMoney() + transferLog.getMoney() <= 20000f) {
                    try {
                        Object proceed = pjp.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("转账超额，只能转帐" + (20000f - moneyLimit.getMoney()));
                }

            } else {
                throw new RuntimeException("24小时内转账金额超过20000元");
            }


        }
        return null;
    }


    @Override
    public int getOrder() {
        return 100;
    }
}
