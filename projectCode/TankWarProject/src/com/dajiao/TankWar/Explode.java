package com.dajiao.TankWar;

import java.awt.*;

/**
 * @program: TankWarProject
 * @description: 爆炸特效
 * @author: Mr.Yu
 * @create: 2020-11-29 10:19
 **/
public class Explode {

    int x;
    int y;

    int diameter[] = {6, 10, 14, 18, 22, 26, 30, 34, 40, 36, 32, 28, 20, 15, 10};
    int step = 0;
    boolean isLive = true;
    TankClient tankClient;

    public Explode(int x, int y, TankClient tankClient) {
        this.x = x;
        this.y = y;
        this.tankClient = tankClient;
    }

    public void draw(Graphics g){

        if (isLive == false){
            tankClient.explodes.remove(this);
            return;
        }
        if (step == diameter.length){
            isLive = false;
            step = 0;
            return;
        }
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, diameter[step], diameter[step]);
        step++;
        g.setColor(color);
    }
}
