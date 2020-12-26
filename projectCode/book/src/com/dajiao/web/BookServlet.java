package com.dajiao.web;

import com.dajiao.pojo.Book;
import com.dajiao.pojo.Page;
import com.dajiao.service.Impl.BookServiceImpl;
import com.dajiao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    BookServiceImpl bookService = new BookServiceImpl();

    protected void bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.list();
        request.setAttribute("books",books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取删除的页数
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //获取要删除的图书id
        int bookId = WebUtils.parseInt(request.getParameter("bookId"), 0);
        bookService.delete(bookId);
        request.getRequestDispatcher("/bookServlet?action=page&pageNo=" + pageNo).forward(request,response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取图书id进行图书信息的显示
        int bookId = WebUtils.parseInt(request.getParameter("bookId"), 0);
        Book book = bookService.getBookById(bookId);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取图书页的pageNo
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //获取图书的所有信息，封装成book对象，用于修改
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.update(book);
        request.getRequestDispatcher("/bookServlet?action=page&pageNo=" + pageNo).forward(request,response);
//        bookList(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取最后一页的pageNo
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //获取图书的所有信息，封装成book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        //永远的加一页，确保跳转到增加的页面
        request.getRequestDispatcher("/bookServlet?action=page&pageNo=" + (pageNo + 1)).forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = Page.getPageSize();
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
