package com.owen.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
public class User {
    private String name;

    private Integer age;

    private Double weight;

    public static void main(String[] args) {
        User user = User.builder().name("张三").age(18).weight(60.00).build();
        System.out.println(user);
    }
}
