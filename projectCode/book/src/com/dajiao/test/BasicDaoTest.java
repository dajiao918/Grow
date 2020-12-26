package com.dajiao.test;

import com.dajiao.dao.BasicDao;
import com.dajiao.pojo.User;

import java.util.List;

import static org.junit.Assert.*;

public class BasicDaoTest {
    BasicDao basicDao = new BasicDao();

    @org.junit.Test
    public void update() {
        String sql = "update t_user set password=? where id = ?";
        int update = basicDao.update(sql, "000000", 4);
        System.out.println(update);
    }

    @org.junit.Test
    public void querySingle() {

        String sql = "select * from t_user where id = ?";
        User user = basicDao.querySingle(sql, User.class, 2);
        System.out.println(user);
    }

    @org.junit.Test
    public void queryMul() {
        String sql = "select * from t_user";
        List<User> users = basicDao.queryMul(sql, User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void querySal() {

        String sql = "select count(*) from t_user";
        Object o = basicDao.querySal(sql);
        System.out.println(o);
    }
}