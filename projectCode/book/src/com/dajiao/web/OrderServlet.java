package com.dajiao.web;

import com.dajiao.pojo.Cart;
import com.dajiao.pojo.Order;
import com.dajiao.pojo.OrderItem;
import com.dajiao.pojo.User;
import com.dajiao.service.Impl.OrderServiceImpl;
import com.dajiao.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 21:05
 **/
public class OrderServlet extends BaseServlet{

    OrderServiceImpl orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //首先判断用户是否登录，不然不能结账
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = user.getId();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String orderId = null;
        orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId",orderId);
        //结完账之后清空购物车
        cart.getMap().clear();
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
    }

    protected void checkOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = user.getId();
        List<OrderItem> orderItems = orderService.checkOrderItem(userId);
        req.getSession().setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/order/checkOrder.jsp").forward(req,resp);

    }

    protected void getOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = user.getId();
        List<Order> orders = orderService.getOrder(userId);
        req.getSession().setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    protected void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderId = req.getParameter("orderId");
        orderService.deleteOder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
