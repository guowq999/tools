package com.owen.transactional.service;

import com.owen.transactional.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private MyDao myDao;

    @Transactional
    public Integer saveUser() {
        Integer num = myDao.saveUser("王五", 19);
        System.out.println(num);
        int a = 10 / 0;
        return num;
    }
}
