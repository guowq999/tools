package com.owen.generic;

/**
 * @author wenqiang
 * @date 2023/07/25 10:09
 **/
public class UserDao extends BaseDao<User>{
    public UserDao() throws InstantiationException, IllegalAccessException {
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        new UserDao();
        Object obj = new User();
    }
}