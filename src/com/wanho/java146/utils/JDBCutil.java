package com.wanho.java146.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class JDBCutil {
    @Autowired
    private DataSource dataSource;

    private static final ThreadLocal<Connection> local = new ThreadLocal<>();

    /**
     * 从本地线程获取连接，如果获取不到，新建一个连接，并把connection放入到线程中
     * 目的：线程共享
     * @return
     */
    public Connection getConnection(){
        Connection connection = local.get();
        if (connection == null){
            try {
                connection = dataSource.getConnection();
                local.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 关闭connection，并将连接从本地线程中移除出去，将本地线程置为空
     * @param connection
     */
    public void closeConnection(Connection connection){
        try {
            connection.close();
            local.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
