package com.dajiao.pojo;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 20:01
 **/
public class OrderItem {

    Integer id;
    String name;
    Double price;
    Integer count;
    Integer toTalPrice;
    String orderId;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Double price, Integer count, Integer toTalPrice, String orderId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.toTalPrice = toTalPrice;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getToTalPrice() {
        return toTalPrice;
    }

    public void setToTalPrice(Integer toTalPrice) {
        this.toTalPrice = toTalPrice;
    }

    public String  getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", toTalPrice=" + toTalPrice +
                ", orderId=" + orderId +
                '}';
    }
}
