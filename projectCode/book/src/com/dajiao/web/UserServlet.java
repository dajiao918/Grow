package com.dajiao.web;

import com.dajiao.pojo.User;
import com.dajiao.service.Impl.UserServiceImpl;
import com.dajiao.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    UserServiceImpl userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    //通过ajax请求验证用户名是否存在
    protected void ajax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean regist = userService.existUser(username);
        Map<String,Object> map = new HashMap<>();
        map.put("existUser",regist);
        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        resp.getWriter().write(toJson);
    }

    //注册方法
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取谷歌验证码
        String attribute = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删除session中的验证码
        req.getSession().invalidate();
        //获取user对象
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //获取验证码参数
        String code = req.getParameter("code");
        if (attribute.equals(code) && attribute != null) {
            if (userService.existUser(user.getUsername())) {
                //代表用户名没有重复
                //保存用户的信息
                userService.saveUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                //代表用户名重复
                req.setAttribute("msg", "用户名已存在");
                //需要回显  信息
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        } else {
            //设置错误信息
            req.setAttribute("msg","验证码错误");
            //表单回显
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);

        //验证登录情况
        if (user != null) {
            //成功使用session域保存当前用户信息
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        } else {
            //失败，保存表单信息，用于回显
            req.setAttribute("username",username);
            //保存失败原因
            req.setAttribute("msg","用户名或密码错误");
            //跳回原页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }
}
