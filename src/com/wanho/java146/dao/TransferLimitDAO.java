package com.wanho.java146.dao;

import com.wanho.java146.pojo.MoneyLimit;
import com.wanho.java146.pojo.TransferLog;

import java.sql.SQLException;

public interface TransferLimitDAO {

    MoneyLimit selectTransferLimit(TransferLog transferLog) throws SQLException;
}
