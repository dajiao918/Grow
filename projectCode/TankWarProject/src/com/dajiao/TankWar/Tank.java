package com.dajiao.TankWar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

/**
 * @program: TankWarProject
 * @description: 坦克类
 * @author: Mr.Yu
 * @create: 2020-11-28 20:51
 **/
public class Tank {

    private int x;
    private int y;
    private int oldX;
    private int oldY;
    private final static int WIDTH = 30;
    private final static int HEIGHT = 30;
    private final static int SPEED = 5;
    private static Random random = new Random();
    private int step = random.nextInt(12) + 3;
    TankClient tankClient;
    private BloodBar bloodBar = new BloodBar();
    boolean good;

    public enum Direction {L, LU, LD, R, RU, RD, U, D, STOP}

    public Direction direction;
    public boolean KL = false, KR = false, KU = false, KD = false;
    public Direction ptDir = Direction.D;
    public boolean isLive = true;
    public int life = 100;

    public Tank(int x, int y, TankClient tankClient, boolean good, Direction direction) {

        this.x = x;
        this.y = y;
        this.tankClient = tankClient;
        this.good = good;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {

        if (!isLive) {
            tankClient.enemyTanks.remove(this);
            return;
        }

        Color color = g.getColor();
        if (good == true) g.setColor(Color.WHITE);
        else g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        if (good) bloodBar.draw(g);
        switch (ptDir) {
            case D:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT);
                break;
            case L:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT / 2);
                break;
            case LD:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y + HEIGHT);
                break;
            case LU:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x, y);
                break;
            case R:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
                break;
            case RU:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y);
                break;
            case RD:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH, y + HEIGHT);
                break;
            case U:
                g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y);
                break;
        }

        move();
    }

    public void move() {

        oldX = x;
        oldY = y;
        switch (direction) {

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
            case STOP:
                break;
        }

        //如果坦克不是停止的话，炮筒的方向才等于坦克的方向，否则是默认朝下
        if (direction != Direction.STOP) {
            ptDir = direction;
        }

        if (x < 0) x = 0;
        if (y < 30) y = 30;
        if (x + WIDTH > TankClient.PAGE_X) x = TankClient.PAGE_X - WIDTH;
        if (y + HEIGHT > TankClient.PAGE_Y) y = TankClient.PAGE_Y - HEIGHT;

        if (!good){
            Direction[] directions = Direction.values();
            if (step == 0) {
                int ranNum = random.nextInt(directions.length);
                direction = directions[ranNum];
                step = random.nextInt(20) + 20;
                this.tankClient.shellList.add(fire());
            }

            step --;
        }
    }

    public void dirStatus() {

        if (KL && !KR && !KU && !KD) {
            direction = Direction.L;
        } else if (KL && !KR && KU && !KD) {
            direction = Direction.LU;
        } else if (KL && !KR && !KU && KD) {
            direction = Direction.LD;
        } else if (!KL && KR && !KU && !KD) {
            direction = Direction.R;
        } else if (!KL && KR && KU && !KD) {
            direction = Direction.RU;
        } else if (!KL && KR && !KU && KD) {
            direction = Direction.RD;
        } else if (!KL && !KR && KU && !KD) {
            direction = Direction.U;
        } else if (!KL && !KR && !KU && KD) {
            direction = Direction.D;
        } else if (!KL && !KR && !KU && !KD) {
            direction = Direction.STOP;
        }
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                KU = true;
                break;
            case KeyEvent.VK_DOWN:
                KD = true;
                break;
            case KeyEvent.VK_LEFT:
                KL = true;
                break;
            case KeyEvent.VK_RIGHT:
                KR = true;
                break;
        }
        dirStatus();
    }

    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_F2:
                if (good || !isLive){
                    this.life = 100;
                    this.isLive = true;
                }
                break;
            case KeyEvent.VK_W:
                if (this.isLive) {
                    tankClient.shellList.add(fire());
                }
                break;
            case KeyEvent.VK_UP:
                KU = false;
                break;
            case KeyEvent.VK_DOWN:
                KD = false;
                break;
            case KeyEvent.VK_LEFT:
                KL = false;
                break;
            case KeyEvent.VK_RIGHT:
                KR = false;
                break;
            case KeyEvent.VK_A:
                superFire();
                break;
        }
        dirStatus();

    }

    public Shell fire() {
        Shell shell = new Shell(x + WIDTH / 2, y + HEIGHT / 2,this.good, ptDir, tankClient);
        return shell;
    }

    public Shell fire(Direction direction) {
        Shell shell = new Shell(x + WIDTH / 2, y + HEIGHT / 2,this.good, direction, tankClient);
        return shell;
    }

    public void superFire(){
        Direction[] directions = Direction.values();

        for (int i = 0; i < directions.length - 1; i++) {
            tankClient.shellList.add(fire(directions[i]));
        }
    }

    public Rectangle getRect() {
        Rectangle rectangle = new Rectangle(x, y, WIDTH, HEIGHT);
        return rectangle;
    }

    private void stay(){
        this.x = oldX;
        this.y = oldY;
    }

    public void isTouch(Wall wall){
        if (getRect().intersects(wall.getRect())){
            stay();
        }
    }

    public void tankIsTouch(Tank tank){
        if (getRect().intersects(tank.getRect())){
            tank.stay();
            this.stay();
        }
    }
    public void tanksIsTouch(List<Tank> tankList){

        for (Tank tank : tankList) {
            if (this != tank ) {
                if (getRect().intersects(tank.getRect())) {
                    tank.stay();
                    this.stay();
                }
            }
        }
    }

    public void eatBlood(Blood blood){
        if (this.life < 100 && isLive && getRect().intersects(blood.getRect()) && blood.isLive){
            this.life = 100;
            blood.isLive = false;
        }
    }

    private class BloodBar{

        public void draw(Graphics g){

            Color color = g.getColor();
            g.setColor(Color.RED);
            g.drawRect(x, y-10, WIDTH, 10);
            g.fillRect(x, y-10, WIDTH*life/100, 10);
            g.setColor(color);
        }
    }

}
