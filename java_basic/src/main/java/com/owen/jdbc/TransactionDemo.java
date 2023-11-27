package com.owen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
    public static void main(String[] args) throws SQLException {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";
        Connection conn = null;
        // 创建连接
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // 关闭事务自动提交
            conn.setAutoCommit(false);

            // 新增数据
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(username, email, gender) VALUES (?,?,?)")) {
                ps.setObject(1, "张三"); // 注意：索引从1开始
                ps.setObject(2, "zhangsan@qq.com");
                ps.setObject(3, 2);
                int n = ps.executeUpdate(); // 这里使用executeUpdate()
            }

            int a = 10 / 0;

            // 更新数据
            try (PreparedStatement ps = conn.prepareStatement("UPDATE users SET username=? WHERE id=?")) {
                ps.setObject(1, "王五"); // 注意：索引从1开始
                ps.setObject(2, 15);
                int n = ps.executeUpdate(); // 返回更新的行数
            }

            // 提交事务
            conn.commit();

        } catch (Exception e) {
            // 抛出异常回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        } finally {
            // 恢复连接原来的状态
            conn.setAutoCommit(true);
            // 关闭连接
            conn.close();
        }
    }
}
