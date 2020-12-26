package com.dajiao.test;

import com.dajiao.pojo.User;
import com.dajiao.service.Impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void regist() {

        boolean admin = userService.existUser("ads");
        if (admin) {
            System.out.println("注册成功");
        } else {
            System.out.println("用户名已存在");
        }

    }

//    @Test
//    public void login() {
//        boolean login = userService.login("admin", "qqq");
//        if (login) {
//            System.out.println("登录成功");
//        } else {
//            System.out.println("用户名或密码错误");
//        }
//    }

    @Test
    public void saveUser() {

        int i = userService.saveUser(new User(null, "jerry", "kerr", "123456@qq.com"));
        System.out.println(i);

    }
}