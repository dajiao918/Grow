package com.dajiao.dao.impl;

import com.dajiao.dao.BasicDao;
import com.dajiao.dao.BookDao;
import com.dajiao.pojo.Book;

import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-13 10:05
 **/
public class BookDaoImpl extends BasicDao implements BookDao {
    @Override
    public List<Book> list() {

        String sql = "select * from t_book";
        List<Book> books = queryMul(sql, Book.class);
        return books;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";
        return querySingle(sql,Book.class,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, price = ?,sales = ?,stock = ? where id = ?";
        return update(sql,book.getName(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public int addBook(Book book) {

        String sql = "insert into t_book(id,name,author,price,sales,stock,img_path) values(?,?,?,?,?,?,?)";
        return update(sql,null,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());

    }

    @Override
    public List<Book> pageTest(Integer begin, Integer size) {

        String sql = "select * from t_book limit ?,?";
        return queryMul(sql, Book.class, begin, size);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) querySal(sql);
        return number.intValue();
    }

    @Override
    public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) querySal(sql, min, max);
        return number.intValue();
    }

    @Override
    public List<Book> queryBookByPrice(int min, int max, int begin, int pageSize) {
        String sql = "select * from t_book where price between ? and ? order by price limit ?,?";
        List<Book> books = queryMul(sql, Book.class, min, max, begin, pageSize);
        return books;
    }


}
