package com.wanho.java146.dao.impl;

import com.wanho.java146.dao.TransferLimitDAO;
import com.wanho.java146.pojo.MoneyLimit;
import com.wanho.java146.pojo.TransferLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransferLimitDAOImplTest {
    @Autowired
    private TransferLimitDAO transferLimitDAO;

    @Test
    public void selectTransferLimit() throws SQLException {
        TransferLog transferLog = new TransferLog();
        transferLog.setSid("c1");
        transferLog.setStatus("SUCCESSFUL_TRANSFER");
        System.out.println(transferLog);
        MoneyLimit moneyLimit = transferLimitDAO.selectTransferLimit(transferLog);
        System.out.println(moneyLimit);

    }
}