package com.wanho.java146.service;

import com.wanho.java146.enumpck.TransferType;
import com.wanho.java146.pojo.Customer;

public interface CustomerService {
    Customer selectById(String cid) ;

    TransferType transfer(String sourceCid,String tagertCid,Float money) ;
}
