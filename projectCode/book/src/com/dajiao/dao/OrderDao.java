package com.dajiao.dao;

import com.dajiao.pojo.Cart;
import com.dajiao.pojo.Order;
import com.dajiao.pojo.OrderItem;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);

    List<Order> getOrder(Integer userId);

    List<OrderItem> getOrderItem(Order order);

    int deleteOrderByOrderId(String orderId);
}
