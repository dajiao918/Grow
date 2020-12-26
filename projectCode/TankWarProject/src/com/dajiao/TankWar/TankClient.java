package com.dajiao.TankWar;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @program: TankWarProject
 * @description: 坦克界面
 * @author: Mr.Yu
 * @create: 2020-11-28 20:34
 **/
public class TankClient extends Frame {

    public final static int PAGE_X = 800;
    public final static int PAGE_Y = 800;

    Image offScreenImage = null;
    Tank tank = new Tank(200,400,this,true, Tank.Direction.STOP);
    Wall wall = new Wall(400,300);
    ArrayList<Shell> shellList = new ArrayList<Shell>();
    ArrayList<Tank> enemyTanks = (ArrayList<Tank>) getEnemyTanks();
    List<Explode> explodes = new ArrayList<>();
    Blood blood = new Blood();


    @Override
    public void paint(Graphics g) {

        g.drawString("shellCount: " + shellList.size(), 20,50 );
        g.drawString("enemyCount: " + enemyTanks.size(), 20,60 );
        g.drawString("explodes: " + explodes.size(), 20,70 );
        g.drawString("坦克大战: " + explodes.size(), 20,80 );

        if (enemyTanks.size() == 0){
            enemyTanks = (ArrayList<Tank>) getEnemyTanks();
        }

        for (Shell shell : shellList){
            shell.hitTanks(enemyTanks);
            shell.hitTank(tank);
            shell.hitWall(wall);
            shell.draw(g);
        }

        for (Tank enemyTank : enemyTanks) {
            enemyTank.isTouch(wall);
            tank.tankIsTouch(enemyTank);
            enemyTank.tanksIsTouch(enemyTanks);
            enemyTank.draw(g);
        }

        for (Explode explode : explodes) {
            explode.draw(g);
        }

        tank.draw(g);
        tank.eatBlood(blood);
        wall.draw(g);
        blood.draw(g);
    }

    public List<Tank> getEnemyTanks(){

        List<Tank> enemyTanks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enemyTanks.add(new Tank(50 + 40*(i+1),50,this,false, Tank.Direction.D));
        }
        return enemyTanks;
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(800, 800);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.green);
        graphics.fillRect(0, 0, 800, 800);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public void launch(){

        setLocation(300,50);
        setSize(PAGE_X,PAGE_Y);
        setBackground(Color.green);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyMonitory());
        setResizable(false);
        setVisible(true);
        new Thread(new KeyThread()).start();
    }

    public static void main(String[] args) {
        new TankClient().launch();
    }

    public class KeyMonitory extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
        }
    }

    public class KeyThread implements Runnable{

        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }

}
