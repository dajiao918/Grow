package com.dajiao.dao.impl;

import com.dajiao.dao.BasicDao;
import com.dajiao.dao.OrderItemDao;
import com.dajiao.pojo.CartItem;
import com.dajiao.pojo.OrderItem;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:14
 **/
public class OrderItemDaoImpl extends BasicDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item values(?,?,?,?,?,?)";
        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getToTalPrice(),orderItem.getOrderId());
    }

    @Override
    public int deleteOrderItemByOrderId(String orderId) {
        String sql = "delete from t_order_item where order_Id = ?";
        return update(sql,orderId);
    }
}
