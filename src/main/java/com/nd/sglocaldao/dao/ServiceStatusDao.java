package com.nd.sglocaldao.dao;

import com.nd.sglocaldao.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


import java.sql.SQLException;

/**
 * Created by youluyao on 2017/8/25 0025
 * 描述：ServiceStatus服务状态 无参数传入 DAO层操作
 */
public class ServiceStatusDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Test
    public void addServiceStatus() {
        try {
            String sql = "INSERT INTO servicestatus(ServiceState,StateName,StateDesc) VALUE (?,?,?)";
            Object[] params = {"123", "启动中", "正在启动中"};
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}















