package com.dajiao.test;

import com.dajiao.dao.impl.OrderItemDaoImpl;
import com.dajiao.pojo.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItemDao= new OrderItemDaoImpl();
        int i = orderItemDao.saveOrderItem(new OrderItem(1, "java数据结构", 100.0, 100, 100, "4521369700"));
        System.out.println(i);
    }
}