package com.owen.jdbc;

import java.sql.*;

public class SelectDemo {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";

        // 获取连接
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 获取Statement
            try (Statement stmt = conn.createStatement()) {
                // 执行查询SQL，返回ResultSet对象
                try (ResultSet rs = stmt.executeQuery("SELECT id,username, email, gender, country FROM users WHERE id=1")) {
                    // 遍历结果集
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        String username = rs.getString(2); // 注意：索引从1开始
                        String email = rs.getString(3);
                        int gender = rs.getInt(4);
                        String country = rs.getString(5);
                        System.out.println("id=" + id + ", username=" + username + ", email=" + email + ", gender=" + gender + ", country=" + country);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
