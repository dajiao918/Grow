package com.dajiao.TankWar;

import java.awt.*;


/**
 * @program: TankWarProject
 * @description:恢复血量
 * @author: Mr.Yu
 * @create: 2020-11-29 21:32
 **/
public class Blood {

    int x;
    int y;
    int width;
    int height;
    int step = 0;
    TankClient tankClient;
    public boolean isLive = true;

    public Blood() {
        x = position[step][0];
        y = position[step][1];
        width = 20;
        height = 20;
    }

    int[][] position = {
                        {300,300},{300,290}, {290,280},{280,270},{290,290},{310,295},{350,920},{370,357},{340,320},{300,280},{280,270},{290,280},{280,270},{290,290},{310,295},{350,920}
    };

    public void draw(Graphics g){

        if (!isLive){
            return;
        }

        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x,y,width,height);
        g.setColor(color);
        move();
    }

    public void move(){

        step ++;
        if (step == position.length){
            step = 0;
        }
        x = position[step][0];
        y = position[step][1];
    }

    public Rectangle getRect() {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        return rectangle;
    }
}
