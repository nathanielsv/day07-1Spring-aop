package com.wanho.java146.service.impl;

import com.wanho.java146.dao.CustomerDAO;
import com.wanho.java146.enumpck.TransferType;
import com.wanho.java146.pojo.Customer;
import com.wanho.java146.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  static com.wanho.java146.enumpck.TransferType.* ;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO ;



    @Override
    public Customer selectById(String cid) {
        return customerDAO.selectById(cid);
    }

    @Override
    public TransferType transfer(String sourceCid, String tagertCid, Float money) {
        //1.查询当前账号
        Customer sourceCustomer = customerDAO.selectById(sourceCid);
        if (sourceCustomer==null){
            return CURRENT_ACCOUNT_NOT_EXIST ;
        }
        //2.查询目标账号
        Customer tagertCustomer = customerDAO.selectById(tagertCid);
        if (tagertCustomer==null){
            return TARGET_ACCOUNT_NOT_EXIST ;
        }
        //3.判断余额
        if (money>sourceCustomer.getCbalance()){
            return INSUFFICIENT_BALANCE ;
        }
        // 设置
        sourceCustomer.setCbalance(sourceCustomer.getCbalance()-money);

        tagertCustomer.setCbalance(tagertCustomer.getCbalance()+money);
        //4.修改当前金额
        int sourceUpdateRs = customerDAO.upadate(sourceCustomer);
        if (sourceUpdateRs!=1){
            return TRANSFER_FAILED ;
        }
//        int i=9/0;
        //5.修改目标金额
        int tagertUpdateRs = customerDAO.upadate(tagertCustomer);
        if (tagertUpdateRs!=1){
            return TRANSFER_FAILED ;
        }
        return SUCCESSFUL_TRANSFER;
    }
}
