package com.dajiao.web;

import com.dajiao.pojo.Book;
import com.dajiao.pojo.Cart;
import com.dajiao.pojo.CartItem;
import com.dajiao.service.Impl.BookServiceImpl;
import com.dajiao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 12:41
 **/
public class CartServlet extends BaseServlet{

    BookServiceImpl bookService = new BookServiceImpl();

    protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取图书对象
        int bookId = WebUtils.parseInt(req.getParameter("bookId"),1);
        Book book = bookService.getBookById(bookId);
        //将图书对象转换成商品对象
        CartItem cartItem = new CartItem(book.getId(), book.getName(), book.getPrice(), 1);
        //首先从session中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        req.getSession().setAttribute("lastName",cartItem.getName());

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addCart(cartItem);
        System.out.println(req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        cart.delete(bookId);
        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        int itemCount = WebUtils.parseInt(req.getParameter("itemCount"), 1);
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 11);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.update(bookId,itemCount);
        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
