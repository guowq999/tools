package com.example.springboot_demo.mapper;

import com.example.springboot_demo.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {
    @Update("update users set username = #{username} where id = #{id}")
    int update(Users users);
}
