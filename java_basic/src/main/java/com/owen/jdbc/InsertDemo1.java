package com.owen.jdbc;

import java.sql.*;

public class InsertDemo1 {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";


        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 第二个参数设置Statement.RETURN_GENERATED_KEYS
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(username, email, gender) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "李四"); // 注意：索引从1开始
                ps.setObject(2, "lisi@qq.com");
                ps.setObject(3, 2);
                int n = ps.executeUpdate(); // 这里依然返回的是影响记录行数

                // 要使用getGeneratedKeys()来获取ResultSet对象
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    // 从ResultSet对象来获取主键id
                    if (rs.next()) {
                        Long id = rs.getLong(1); // 注意：索引从1开始
                        System.out.println(id);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
