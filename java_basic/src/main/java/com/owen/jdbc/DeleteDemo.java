package com.owen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?")) {
                ps.setObject(1, "李四"); // 注意：索引从1开始
                int n = ps.executeUpdate(); // 返回更新的行数
                System.out.println(n);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
