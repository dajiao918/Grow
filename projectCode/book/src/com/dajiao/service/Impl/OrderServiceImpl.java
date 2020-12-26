package com.dajiao.service.Impl;

import com.dajiao.dao.impl.OrderDaoImpl;
import com.dajiao.dao.impl.OrderItemDaoImpl;
import com.dajiao.pojo.*;
import com.dajiao.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:42
 **/
public class OrderServiceImpl implements OrderService {

    OrderDaoImpl orderDao = new OrderDaoImpl();
    OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    BookServiceImpl bookService = new BookServiceImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + userId + "";
        Order order = new Order(userId, new Date(), cart.getTotalPrice(), orderId);
        orderDao.saveOrder(order);

//        int x = 12/0;

        for (Map.Entry<Integer, CartItem> item : cart.getMap().entrySet()){

            CartItem cartItem = item.getValue();
            OrderItem orderItem = new OrderItem(cartItem.getId(), cartItem.getName(), cartItem.getPrice(), cartItem.getToTalCount(), (int) cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookService.getBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getToTalCount());
            book.setStock(book.getStock() - cartItem.getToTalCount());
            bookService.update(book);
        }

        return orderId;
    }

    @Override
    public List<OrderItem> checkOrderItem(Integer userId) {
        List<Order> orders = orderDao.getOrder(userId);
        List<OrderItem> orderItems = new ArrayList<>();
        for (Order order : orders) {
            List<OrderItem> orderItem = orderDao.getOrderItem(order);
            for (OrderItem item : orderItem) {
                orderItems.add(item);
            }
        }
        return orderItems;
    }

    @Override
    public List<Order> getOrder(Integer userId) {
        List<Order> orders = orderDao.getOrder(userId);
        return orders;
    }

    @Override
    public int deleteOder(String orderId) {
        orderItemDao.deleteOrderItemByOrderId(orderId);
        return orderDao.deleteOrderByOrderId(orderId);
    }


}
