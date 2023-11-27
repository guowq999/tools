package com.owen.transactional.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer saveUser(String userName, Integer age) {
        String sql = "INSERT INTO `test`.`t_user`(`user_name`, `age`) VALUES (?, ?)";
        int num = jdbcTemplate.update(sql, userName, age);
        return num;
    }
}
