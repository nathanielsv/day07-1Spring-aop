package com.wanho.java146.dao.impl;

import com.wanho.java146.dao.CustomerDAO;
import com.wanho.java146.pojo.Customer;
import com.wanho.java146.utils.JDBCutil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private QueryRunner queryRunner ;
    @Autowired
    private JDBCutil jdbCutil;


    @Override
    public Customer selectById(String cid) {
        try {
            return queryRunner.query(jdbCutil.getConnection(),"select * from t_customer where cid = ?",new BeanHandler<>(Customer.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据id查询异常") ;
        }
    }

    @Override
    public int upadate(Customer customer) {
        try {
            return queryRunner.update(jdbCutil.getConnection(),"update t_customer set cname = ? ,cbalance = ? where cid=?" ,customer.getCname(),customer.getCbalance(),customer.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("更新异常") ;
        }
    }
}
