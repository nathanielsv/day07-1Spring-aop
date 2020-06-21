package com.wanho.java146.dao.impl;

import com.wanho.java146.dao.TransferLogDAO;
import com.wanho.java146.pojo.TransferLog;
import com.wanho.java146.utils.JDBCutil;
import com.wanho.java146.utils.NOutil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransferLogDAOImpl implements TransferLogDAO {
    @Autowired
    private JDBCutil jdbCutil;
    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private NOutil NOutil;


    @Override
    public int insert(TransferLog transferLog) {
        String sql = "INSERT INTO t_transfer_log(NO, sid, tid,money,begin_time,end_time,STATUS,msg,exception) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            return queryRunner.execute(jdbCutil.getConnection(),sql,
                    NOutil.getNo(),
                    transferLog.getSid(),
                    transferLog.getTid(),
                    transferLog.getMoney(),
                    transferLog.getBeginTime(),
                    transferLog.getEndTime(),
                    transferLog.getStatus(),
                    transferLog.getMsg(),
                    transferLog.getException());



        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("新增转账失败");
        }


    }

}
