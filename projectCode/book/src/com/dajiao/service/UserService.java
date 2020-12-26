package com.dajiao.service;

import com.dajiao.pojo.User;

public interface UserService {

    public boolean existUser(String username);

    public User login(String username,String password);

    public int saveUser(User user);

}
