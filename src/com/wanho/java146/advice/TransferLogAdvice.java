package com.wanho.java146.advice;

import com.wanho.java146.dao.TransferLogDAO;
import com.wanho.java146.enumpck.TransferType;
import com.wanho.java146.pojo.TransferLog;
import com.wanho.java146.utils.JDBCutil;
import com.wanho.java146.utils.NOutil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;

@Component
public class TransferLogAdvice {
    @Autowired
    private TransferLogDAO transferLogDAO;
    @Autowired
    private JDBCutil jdbCutil;



    public Object doTransferLog(ProceedingJoinPoint pjp) throws SQLException {
        TransferLog transferLog = new TransferLog();
        System.out.println("日志执行");
        Object[] pjpArgs = pjp.getArgs();
        transferLog.setSid((String)pjpArgs[0]);
        transferLog.setTid((String)pjpArgs[1]);
        transferLog.setMoney((Float)pjpArgs[2]);
        transferLog.setBeginTime(new Date());

        try {
            //切面方法执行的返回值是一个枚举值
            Object proceedReturn = pjp.proceed();
            transferLog.setEndTime(new Date());
            //强转枚举对象
              TransferType transferType = (TransferType) proceedReturn;
            //将枚举值设置为状态码
            transferLog.setStatus(transferType.toString());
            transferLog.setMsg(transferType.getMsg());
            System.out.println(transferLog);
            transferLogDAO.insert(transferLog);
            jdbCutil.getConnection().commit();
            System.out.println("日志执行结束");
            return proceedReturn;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            transferLog.setEndTime(new Date());
            transferLog.setException(throwable.getMessage());
            System.out.println(throwable.getMessage());
            transferLogDAO.insert(transferLog);
            jdbCutil.getConnection().commit();

        }

        return null;

    }
}
