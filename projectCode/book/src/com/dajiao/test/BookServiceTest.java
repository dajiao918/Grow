package com.dajiao.test;

import com.dajiao.pojo.Page;
import com.dajiao.service.Impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void page() {

        BookServiceImpl bookService = new BookServiceImpl();
        Page page = bookService.page(1, 4);
        System.out.println(page);

    }

    @Test
    public void pageByPrice() {
        BookServiceImpl bookService = new BookServiceImpl();
        Page page = bookService.pageByPrice(0, 100, 2, 4);
        List books = page.getPageBooks();
        for (Object book : books) {
            System.out.println(book);
        }
    }
}