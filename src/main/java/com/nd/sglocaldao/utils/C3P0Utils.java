package com.nd.sglocaldao.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by youluyao on 2017/8/24 0024
 * 描述：下面是通过C3P0获得数据源，注意不同数据源时ComboPooledDataSource参数不同
 */
public class C3P0Utils {
    // private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("localmysql");
    public static DataSource getDataSource() {
        return dataSource;
    }
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
