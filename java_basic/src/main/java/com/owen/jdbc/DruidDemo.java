package com.owen.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * try() 可以释放连接池连接
 */
public class DruidDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8");
        properties.setProperty("username", "root");
        properties.setProperty("password", "521125");
        properties.setProperty("initialSize", "5"); // 初始化连接数量
        properties.setProperty("maxActive", "10"); // 最大连接数量
        properties.setProperty("maxWait", "3000"); // 连接最大超时时间

        try {
            // 创建连接池
            DataSource dataSe = DruidDataSourceFactory.createDataSource(properties);

            // 从连接池获取连接
            Connection conn = dataSe.getConnection();

            // 执行SQL
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(username, email, gender) VALUES (?,?,?)")) {
                ps.setObject(1, "张三"); // 注意：索引从1开始
                ps.setObject(2, "zhangsan@qq.com");
                ps.setObject(3, 2);
                int n = ps.executeUpdate(); // 这里使用executeUpdate()
            }

            // 释放连接，这里是把连接返回连接池
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
