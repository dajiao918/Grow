package com.dajiao.service;

import com.dajiao.pojo.Cart;
import com.dajiao.pojo.Order;
import com.dajiao.pojo.OrderItem;

import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:43
 **/
public interface OrderService {

    public String  createOrder(Cart cart, Integer userId);

    List<OrderItem> checkOrderItem(Integer userId);

    List<Order> getOrder(Integer userId);

    int deleteOder(String orderId);
}
