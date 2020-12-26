package com.dajiao.service;

import com.dajiao.pojo.Book;
import com.dajiao.pojo.Page;

import java.util.List;

public interface BookService {

    public List<Book> list();

    int delete(Integer id);

    Book getBookById(Integer id);

    int update(Book book);

    int addBook(Book book);

    Page page(Integer pageNo, Integer pageSize);

    Page pageByPrice(int min, int max, int pageNo, int pageSize);
}
