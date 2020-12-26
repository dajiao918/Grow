package com.dajiao.test;

import com.dajiao.dao.impl.OrderDaoImpl;
import com.dajiao.pojo.Order;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int i = orderDao.saveOrder(new Order(5, new Date(), 100.0, "4521369700"));
        System.out.println(i);
    }

    @Test
    public void getOrderId() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.getOrder(1);
        for (Order order : orders){
            System.out.println(order);
        }
    }
}