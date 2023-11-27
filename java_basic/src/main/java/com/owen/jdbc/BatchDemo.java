package com.owen.jdbc;

import java.sql.*;

public class BatchDemo {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&rewriteBatchedStatements=true";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "521125";

        long start = System.currentTimeMillis();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(username, email, gender) VALUES (?,?,?)")) {

                // 批量插入5条记录
                for (int i = 0; i < 10000; i++) {
                    ps.setObject(1, "李四" + i);
                    ps.setObject(2, "lisi" + i + "@qq.com");
                    ps.setObject(3, 2);
                    
                    // 这里不再是执行SQL语句了，变成添加到batch
                    ps.addBatch();
                }

                // 执行所有SQL
                int[] ns = ps.executeBatch();
                
//                // 查看每个SQL的返回结果
//                for (int n : ns) {
//                    System.out.println(n + " inserted.");
//                }
                conn.commit();
            }

            long end = System.currentTimeMillis();

            System.out.println("time:" + (end - start));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
