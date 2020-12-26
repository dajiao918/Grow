package com.dajiao.test;

import com.dajiao.dao.impl.BookDaoImpl;
import com.dajiao.pojo.Book;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {

    BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void list() {
        List<Book> list = bookDao.list();
        for (Book book : list) {
            System.out.println(book);
        }
    }

    @Test
    public void deleteById() {
        int i = bookDao.deleteById(5);
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(11);
        System.out.println(book);
    }

    @Test
    public void updateBook() {

        Book book = new Book(12, "java数据结构之广哥", 123.0, "广哥", 54, 45, null);
        int i = bookDao.updateBook(book);
        System.out.println(i);
    }

    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "java编程思想", 200.0, "作者", 65, 45, null));
        System.out.println(i);
    }

    @Test
    public void pageForLimit() {

        List<Book> books = bookDao.pageTest(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }

    }

    @Test
    public void queryForPageTotalCount() {
        Integer i = bookDao.queryForPageTotalCount();
        System.out.println(i);
    }

    @Test
    public void queryForPageByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(0, 50);
        System.out.println(integer);
    }

    @Test
    public void queryBookByPrice() {
        List<Book> books = bookDao.queryBookByPrice(0, 100,1,4);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}