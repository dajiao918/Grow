package com.dajiao.dao;

import com.dajiao.pojo.CartItem;
import com.dajiao.pojo.OrderItem;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:16
 **/
public interface OrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

    int deleteOrderItemByOrderId(String orderId);
}
