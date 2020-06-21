package com.wanho.java146.dao;

import com.wanho.java146.pojo.TransferLog;

import java.sql.SQLException;

public interface TransferLogDAO {

    int insert(TransferLog transferLog) throws SQLException;
}
