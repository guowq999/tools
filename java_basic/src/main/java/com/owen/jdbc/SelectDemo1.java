package com.owen.jdbc;

import java.sql.*;

public class SelectDemo1 {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,username, email, gender, country FROM users WHERE gender = ? AND country = ?")) {
                ps.setObject(1, 3); // 注意：索引从1开始
                ps.setObject(2, "Germany");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        // 这里可用索引的形式，也可以使用列名称的形式
                        long id = rs.getLong("id");
                        String username = rs.getString("username");
                        String email = rs.getString("email");
                        int gender = rs.getInt("gender");
                        String country = rs.getString("country");
                        System.out.println("id=" + id + ", username=" + username + ", email=" + email + ", gender=" + gender + ", country=" + country);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
