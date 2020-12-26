package com.dajiao.web;

import com.dajiao.pojo.Page;
import com.dajiao.service.BookService;
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
 * @create: 2020-12-14 11:43
 **/
public class ClientServlet extends BaseServlet{

    BookServiceImpl bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageNo参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = Page.getPageSize();
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("clientServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageNo参数
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = Page.getPageSize();

        Page page = bookService.pageByPrice(min, max, pageNo, pageSize);
        StringBuilder sb = new StringBuilder("clientServlet?action=pageByPrice");
        sb.append("&min=" + req.getParameter("min"));
        sb.append("&max=" + req.getParameter("max"));
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
