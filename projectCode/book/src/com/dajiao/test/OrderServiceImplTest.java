package com.dajiao.test;

import com.dajiao.pojo.OrderItem;
import com.dajiao.service.Impl.OrderServiceImpl;
import org.junit.Test;

import java.util.List;

public class OrderServiceImplTest {

    @Test
    public void checkOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderItem> orderItems = orderService.checkOrderItem(1);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}