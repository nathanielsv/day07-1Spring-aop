package com.wanho.java146.dao.impl;

import com.wanho.java146.dao.TransferLimitDAO;
import com.wanho.java146.pojo.MoneyLimit;
import com.wanho.java146.pojo.TransferLog;
import com.wanho.java146.utils.JDBCutil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransferLimitDAOImpl implements TransferLimitDAO {
    @Autowired
    private JDBCutil jdbCutil;
    @Autowired
    private QueryRunner queryRunner;

    private static final String sql="SELECT SUM(money) money from t_transfer_log " +
            "where TIMESTAMPDIFF(HOUR,end_time,now())<24 " +
            "and sid = ? and status=?";
    @Override
    public MoneyLimit selectTransferLimit(TransferLog transferLog) throws SQLException {
//        System.out.println(transferLog);
        return queryRunner.query(jdbCutil.getConnection(),sql,new BeanHandler<>(MoneyLimit.class),
               transferLog.getSid(),transferLog.getStatus());

    }
}
