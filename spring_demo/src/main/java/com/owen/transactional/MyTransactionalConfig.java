package com.owen.transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@ComponentScan(basePackages = "com.owen.transactional")
@Configuration
public class MyTransactionalConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource() ;
        d.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC"); //设置url
        // 上述的test为你的数据库名
        d.setUsername("root"); //设置账号
        d.setPassword("521125"); //设置密码
        return d;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
