package com.wanho.java146.proxy;

import com.wanho.java146.transaction.TransactionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 手写代理类，与spring AOP无关
 */

@Component
public class TransferProxy {
    @Autowired
    @Qualifier("customerServiceImpl")
    private Object target;
    @Autowired
    private TransactionProxy transactionProxy;

    public Object useProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //开启事务
                transactionProxy.beginTransaction();
                //被代理类执行的方法返回值，就是枚举值
                try {
                    Object invokeReturn = method.invoke(target, args);
                    //事务执行
                    transactionProxy.commitTransaction();
                    return invokeReturn;
                } catch (Exception e) {
                    //出异常，事务回滚
                    transactionProxy.rollbackTransaction();
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

}
