package com.dajiao.test;

import com.dajiao.pojo.Cart;
import com.dajiao.pojo.CartItem;
import org.junit.Test;

import java.util.Map;

public class CartTest {

    @Test
    public void addCart() {

        CartItem cartItem = new CartItem(1, "name", 30.0, 1);
        CartItem cartItem1 = new CartItem(1, "name", 30.0, 1);
        CartItem cartItem3 = new CartItem(1, "name", 30.0, 1);
        CartItem cartItem2 = new CartItem(2, "alan", 100.0, 1);
        Cart cart = new Cart();
        cart.addCart(cartItem);
        cart.addCart(cartItem1);
        cart.addCart(cartItem3);
        cart.addCart(cartItem2);
        Map<Integer,CartItem> cartItemMap = cart.getMap();

        for(Map.Entry<Integer,CartItem> item : cartItemMap.entrySet()) {
            System.out.println(item);
        }

        Integer totalCount = cart.getTotalCount();
        double totalPrice = cart.getTotalPrice();
        System.out.println(totalCount);
        System.out.println(totalPrice);

    }
}