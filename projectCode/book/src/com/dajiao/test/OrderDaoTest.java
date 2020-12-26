package com.dajiao.test;

import com.dajiao.dao.BasicDao;
import com.dajiao.dao.impl.OrderDaoImpl;
import com.dajiao.pojo.Order;
import com.dajiao.pojo.OrderItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoTest {

    @Test
    public void getOrderItem() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.getOrder(1);
        List<OrderItem> orderItems = new ArrayList<>();
        for (Order order : orders) {
            List<OrderItem> orderItem = orderDao.getOrderItem(order);
            for (OrderItem item : orderItem) {
                orderItems.add(item);
            }
        }
        for (OrderItem item : orderItems) {
            System.out.println(item);
        }
    }

    @Test
    public void test(){
        BasicDao basicDao = new BasicDao();
        String sql = "select id,name,price,count,total_price as totalPrice,order_Id as orderId from t_order_item where id = ?";
        OrderItem orderItem = basicDao.querySingle(sql, OrderItem.class, 12);
        System.out.println(orderItem);
    }
}