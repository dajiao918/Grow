package com.dajiao.service.Impl;

import com.dajiao.dao.impl.BookDaoImpl;
import com.dajiao.pojo.Book;
import com.dajiao.pojo.Page;
import com.dajiao.service.BookService;

import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-13 10:01
 **/
public class BookServiceImpl implements BookService {

    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> list() {
        return bookDao.list();
    }

    @Override
    public int delete(Integer id) {
        return bookDao.deleteById(id);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public int update(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Page page(Integer pageNo, Integer  pageSize) {
        //获取总的数据量
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0){
            pageTotal = pageTotal + 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1){
            pageNo = 1;
        }
        //获取索引
        int begin = (pageNo-1)*pageSize;
        //获取总的页数
        List<Book> pageBooks = bookDao.pageTest(begin, pageSize);
        Page<Book> page = new Page<>(pageNo, pageTotalCount, pageTotal, pageBooks);
        return page;
    }

    @Override
    public Page pageByPrice(int min, int max, int pageNo, int pageSize) {
        //获取总的数据量
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0){
            pageTotal = pageTotal + 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1){
            pageNo = 1;
        }
        //获取索引
        int begin = (pageNo-1)*pageSize;
        //获取总的页数
        List<Book> pageBooks = bookDao.queryBookByPrice(min, max, begin, pageSize);
        Page<Book> page = new Page<>(pageNo, pageTotalCount, pageTotal, pageBooks);
        return page;
    }
}
