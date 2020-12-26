package com.dajiao.dao.impl;

import com.dajiao.dao.BasicDao;
import com.dajiao.dao.OrderDao;
import com.dajiao.pojo.Order;
import com.dajiao.pojo.OrderItem;

import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:13
 **/
public class OrderDaoImpl extends BasicDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order values(?,?,?,?)";
        return update(sql,order.getOrderId(),order.getOrderTime(),order.getPrice(),order.getUserId());
    }

    @Override
    public List<Order> getOrder(Integer userId) {
        String sql = "select o.orderId, o.create_time orderTime,o.price,o.user_id userId from t_user u join t_order o on u.id = o.user_id where u.id = ?";
        List<Order> orders = queryMul(sql, Order.class, userId);
        return orders;
    }

    @Override
    public List<OrderItem> getOrderItem(Order order) {

        String sql = "select id,name,price,count,total_price as totalPrice,order_Id as orderId from t_order_item where order_Id = ?";
        return queryMul(sql,OrderItem.class,order.getOrderId());
    }

    @Override
    public int deleteOrderByOrderId(String orderId) {
        String sql = "delete from t_order where orderId = ?";
        return update(sql,orderId);
    }


}
