package com.wanho.java146.service.impl;

import com.wanho.java146.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerServiceImplTest {
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @Test
    public void transfer() {
        customerService.transfer("c3","c2",20000f);
    }
}