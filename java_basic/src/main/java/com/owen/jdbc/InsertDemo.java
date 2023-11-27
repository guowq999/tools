package com.owen.jdbc;

import java.sql.*;

public class InsertDemo {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(username, email, gender) VALUES (?,?,?)")) {
                ps.setObject(1, "张三"); // 注意：索引从1开始
                ps.setObject(2, "zhangsan@qq.com");
                ps.setObject(3, 2);
                int n = ps.executeUpdate(); // 这里使用executeUpdate()
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
