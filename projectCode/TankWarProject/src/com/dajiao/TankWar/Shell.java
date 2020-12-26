package com.dajiao.TankWar;

import java.awt.*;
import java.util.ArrayList;

/**
 * @program: TankWarProject
 * @description: 子弹类
 * @author: Mr.Yu
 * @create: 2020-11-28 21:58
 **/
public class Shell {

    int x;
    int y;
    public Tank.Direction direction;
    public final static int SPEED = 10;
    TankClient tankClient;
    public boolean isLive = true;
    boolean good;

    public Shell(int x, int y, boolean good, Tank.Direction direction, TankClient tankClient) {
        this.x = x;
        this.y = y;
        this.good = good;
        this.direction = direction;
        this.tankClient = tankClient;
    }

    public void draw(Graphics g){

        if (!isLive){
            tankClient.shellList.remove(this);
            return;
        }

        Color color = g.getColor();
        if (this.good) g.setColor(Color.black);
        else g.setColor(Color.red);
        g.fillOval(x, y,10,10);
        g.setColor(color);
        move();
    }

    public void move(){

        switch (direction){

            case D:
                y += SPEED;
                break;
            case L:
                x -= SPEED;
                break;
            case LD:
                x -= SPEED;
                y += SPEED;
                break;
            case LU:
                x -= SPEED;
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case RU:
                x += SPEED;
                y -= SPEED;
                break;
            case RD:
                x += SPEED;
                y += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
        }

        if (x > TankClient.PAGE_X || x < 0) tankClient.shellList.remove(this);
        if (y > tankClient.PAGE_Y ||  y < 30) tankClient.shellList.remove(this);
    }

    public Rectangle getRect(){
        Rectangle rectangle = new Rectangle(x, y, 10, 10);
        return rectangle;
    }

    public void hitTank(Tank tank){
        if (getRect().intersects(tank.getRect()) && tank.isLive && this.good != tank.good ){

            if (tank.good) {
                tank.life -= 20;
                if (tank.life <= 0) tank.isLive = false;
            } else{
                tank.isLive = false;
            }

            Explode explode = new Explode(tank.getX(), tank.getY(),tank.tankClient);
            tankClient.explodes.add(explode);
            this.isLive = false;
        }
    }

    public void hitWall(Wall wall){
        if (getRect().intersects(wall.getRect())){
            this.isLive = false;
        }
    }

    public void hitTanks(ArrayList<Tank> enemyTanks){

        for (Tank enemyTank : enemyTanks){
            hitTank(enemyTank);
        }
    }
}
