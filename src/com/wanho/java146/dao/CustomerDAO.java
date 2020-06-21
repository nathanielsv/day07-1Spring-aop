package com.wanho.java146.dao;

import com.wanho.java146.pojo.Customer;

public interface CustomerDAO {
    Customer selectById(String cid) ;

    int upadate(Customer customer) ;
}
