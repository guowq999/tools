package com.owen.transactional;

import com.owen.transactional.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyTransactionalConfig.class);
//        DataSource d = (DataSource) ac.getBean("dataSource");
//        Connection c = d.getConnection(); //获取连接
//        System.out.println(c);

        MyService myService = (MyService) ac.getBean("myService");
        myService.saveUser();
    }
}
