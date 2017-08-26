package com.nd.sglocaldao.dao;

import com.nd.sglocaldao.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by youluyao on 2017/8/25 0025
 * 描述：ServiceStatus服务状态 无参数传入 DAO层操作
 */
public class ServiceStatusDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    // 添加记录
    @Test
    public void addServiceStatus() {
        try {
            String sql = "INSERT INTO servicestatus(ServiceState,StateName,StateDesc) VALUE (?,?,?)";
            Object[] params = {"223", "启动中", "正在启动中"};
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //判断数据表中是否存在某字段
    @Test
    public void ifexist() {
        String ss="223";
        try {
            String sql = "SELECT ServiceState FROM servicestatus";
            List<String> list = qr.query(sql,new ColumnListHandler<String>());
            for (String str : list){
                if(str.equals(ss))
                {
                    System.out.println("数据表中已存在该元素");
                    return;
                }
            }
            System.out.println("数据表中不存在该元素");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //给某个表添加外键
    @Test
    public void addFOREIGNKEY(){
        try {
            String sql="ALTER TABLE d123 ADD CONSTRAINT yluy FOREIGN KEY (ServiceState) REFERENCES servicestatus (ServiceState)";
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}















