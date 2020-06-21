package com.wanho.java146.dao.impl;

import com.wanho.java146.dao.TransferLogDAO;
import com.wanho.java146.pojo.TransferLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransferLogDAOImplTest {
    @Autowired
    private TransferLogDAO transferLogDAO;
    @Autowired
    private TransferLog transferLog;

    @Test
    public void insert() throws SQLException {
        transferLog.setNO("23");
        transferLog.setTid("1");
        transferLog.setSid("aa");
        transferLog.setBeginTime(new Date());
        transferLog.setEndTime(new Date());
        transferLogDAO.insert(transferLog);

    }
}