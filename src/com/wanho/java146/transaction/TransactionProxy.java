package com.wanho.java146.transaction;


import com.wanho.java146.utils.JDBCutil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect
public class TransactionProxy implements Ordered {

    @Autowired
    private JDBCutil jdbCutil;

    @Pointcut("execution(* com.wanho.java146.service.impl.CustomerServiceImpl.transfer(..))")
    private void hello(){}

    public void beginTransaction(){
        Connection connection = jdbCutil.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void commitTransaction(){
        System.out.println("事务执行结束");
        Connection connection = jdbCutil.getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollbackTransaction(){
        Connection connection = jdbCutil.getConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Around("hello()")
    public Object aroundTransaction(ProceedingJoinPoint pjp){

        System.out.println("事物执行。。。。。。。。");

        try {
            beginTransaction();
            Object proceed = pjp.proceed();
            commitTransaction();

            return proceed;
        } catch (Throwable throwable) {
            rollbackTransaction();
            throwable.printStackTrace();
        }
        return null;
    }


    @Override
    public int getOrder() {
        return 300;
    }
}
