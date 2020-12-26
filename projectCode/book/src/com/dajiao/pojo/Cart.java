package com.dajiao.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-15 10:47
 **/
public class Cart {

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    Map<Integer, CartItem> map = new HashMap<>();

    //加入购物车
    public void addCart(CartItem cartItem) {

        CartItem item = map.get(cartItem.getId());
        if (item == null){
            map.put(cartItem.getId(),cartItem);
        } else {
            item.setToTalCount(item.getToTalCount() + 1);
            map.put(item.getId(),item);
        }

    }

    //删除当前商品
    public void delete(Integer id) {
        map.remove(id);
    }

    //清空购物车
    public void clear(){
        map.clear();
    }

    //修改商品数量
    public void update(Integer id,Integer count) {

        CartItem cartItem = map.get(id);
        cartItem.setToTalCount(count);
    }

    public Integer getTotalCount() {
        Integer TotalCount = 0;
        for (Map.Entry<Integer,CartItem> map : map.entrySet()) {
            TotalCount += map.getValue().getToTalCount();
        }

        return TotalCount;
    }

    public double getTotalPrice() {
        double TotalPrice = 0;
        for (Map.Entry<Integer,CartItem> map : map.entrySet()) {
            TotalPrice += map.getValue().getTotalPrice();
        }

        return TotalPrice;
    }

}
