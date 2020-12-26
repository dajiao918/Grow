package com.dajiao.pojo;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 10:47
 **/
public class CartItem {

    private Integer id;
    private String name;
    private Double price;
    private Integer ToTalCount = 1;

    public CartItem() {
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

    public double getTotalPrice() {
        return price * ToTalCount;
    }

    public Integer getToTalCount() {
        return ToTalCount;
    }

    public void setToTalCount(Integer toTalCount) {
        ToTalCount = toTalCount;
    }

    public CartItem(Integer id, String name, Double price, Integer toTalCount) {
        this.id = id;
        this.name = name;
        this.price = price;
        ToTalCount = toTalCount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price  +
                ", ToTalCount=" + ToTalCount +
                '}';
    }
}
