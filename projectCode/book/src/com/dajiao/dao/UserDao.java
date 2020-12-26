package com.dajiao.dao;

import com.dajiao.pojo.User;

public interface UserDao {

    public User getUserByName(String username);

    public User getUserByNameAndPassword(String username,String password);

    public int saveUser(User user);

}
