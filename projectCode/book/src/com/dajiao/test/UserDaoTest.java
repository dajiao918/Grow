package com.dajiao.test;

import com.dajiao.dao.impl.UserDaoImpl;
import com.dajiao.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void getUserByName() {
        User admin = userDao.getUserByName("admin");
        System.out.println(admin);
    }

    @Test
    public void getUserByNameAndPassword() {
        User user = userDao.getUserByNameAndPassword("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User(null, "jack", "jack", "123456@qq.com");
        int i = userDao.saveUser(user);
        System.out.println(i);

    }
}