package com.dajiao.dao.impl;

import com.dajiao.dao.BasicDao;
import com.dajiao.dao.UserDao;
import com.dajiao.pojo.User;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-11 12:48
 **/
public class UserDaoImpl extends BasicDao implements UserDao {

    @Override
    public User getUserByName(String username) {
        String sql = "select * from t_user where username = ?";
        User user = querySingle(sql, User.class, username);
        return user;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        User user = querySingle(sql, User.class, username,password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(?,?,?,?)";
        return update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
    }
}
