package com.dajiao.service.Impl;

import com.dajiao.dao.impl.UserDaoImpl;
import com.dajiao.pojo.User;
import com.dajiao.service.UserService;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-11 13:13
 **/
public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean existUser(String username) {
        User user = userDao.getUserByName(username);
        if (user == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(String username, String password) {
        return userDao.getUserByNameAndPassword(username, password);
    }

    @Override
    public int saveUser(User user) {
        int i = userDao.saveUser(user);
        return i;
    }
}
