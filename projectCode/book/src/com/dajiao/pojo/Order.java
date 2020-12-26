package com.dajiao.pojo;

import java.util.Date;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:01
 **/
public class Order {

    Integer userId;
    Date orderTime;
    Double price;
    String orderId;


    public Order() {
    }

    public Order(Integer userId, Date orderTime, Double price, String orderId) {
        this.userId = userId;
        this.orderTime = orderTime;
        this.price = price;
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", orderTime=" + orderTime +
                ", price=" + price +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
