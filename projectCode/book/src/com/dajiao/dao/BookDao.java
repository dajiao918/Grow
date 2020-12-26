package com.dajiao.dao;

import com.dajiao.pojo.Book;

import java.util.List;

public interface BookDao {


    List<Book> list();

    int deleteById(Integer id);

    Book queryBookById(Integer id);

    int updateBook(Book book);

    int addBook(Book book);

    List<Book>  pageTest(Integer begin,Integer size);

    Integer queryForPageTotalCount();

    Integer queryForPageTotalCountByPrice(Integer min, Integer max);

    List<Book> queryBookByPrice(int min, int max, int begin, int pageSize);
}
