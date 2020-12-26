package com.dajiao.TankWar;

import java.awt.*;

/**
 * @program: TankWarProject
 * @description:
 * @author: Mr.Yu
 * @create: 2020-11-29 15:46
 **/
public class Wall {

    int x;
    int y;
    int width = 20;
    int height = 500;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){

        Color color = g.getColor();
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
        g.setColor(color);
    }

    public Rectangle getRect() {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        return rectangle;
    }
}
