package com.yk.TankGame_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Tang
 * @version 1.0
 *
 */
public class MyPanel_ extends JPanel implements KeyListener {
    //定义我的坦克
    MyTank_ myTank = null;
    //Define EnemyTankVector
    Vector<EnemyTank_> enemyTank_s = new Vector<>();
    int EnemyTank_VectorSize = 3;
    //Constructor
    public MyPanel_(){
        myTank = new MyTank_(100,100, 0);   //Initialize MyTank

        for (int i = 0; i < EnemyTank_VectorSize ; i++) {  //Initialize EnemyTank
            enemyTank_s.add(new EnemyTank_((i + 1)*100, 0, 2));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750); //背景渲染

        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(),1);

        for (int i = 0; i < EnemyTank_VectorSize; i++) {
            EnemyTank_ enemyTank_ = enemyTank_s.get(i);
            drawTank(enemyTank_.getX(), enemyTank_.getY(), g, enemyTank_.getDirect(),0);
        }
    }

    /**
     *
     * @param x 坦克初始横坐标
     * @param y ...纵坐标
     * @param g 传入画笔，以获取颜色
     * @param direct 坦克朝向
     * @param Type 坦克类型: 0表示我方坦克，1表示敌方坦克
     */
    public void drawTank(int x, int y, Graphics g, int direct, int Type){
        switch(Type){   //根据类型选择坦克颜色
            case 0 :
                g.setColor(Color.cyan);
                break;
            case 1 :
                g.setColor(Color.yellow);
                break;
        }
        //坦克所占空间为40*60
        //0 1 2 3 分别表示 坦克朝向 上 右 下 左
        switch (direct){
            case 0 ://上
                g.fill3DRect(x, y, 10, 60, false); //左轮
                g.fill3DRect(x+10, y+10, 20, 40, false);//主体
                g.fill3DRect(x+30, y, 10, 60, false);//右轮
                g.fillOval(x+10, y+20, 20,20);//炮塔
                g.drawLine(x+20,y+30,x+20, y );//炮筒
                break;
            case 1 ://右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x+10, y+10, 40, 20, false);
                g.fill3DRect(x, y+30, 60, 10, false);
                g.fillOval(x+20, y+10, 20,20);
                g.drawLine(x+30,y+20,x+60, y+20 );
                break;
            case 2 ://下
                g.fill3DRect(x, y, 10, 60, false); //左轮
                g.fill3DRect(x+10, y+10, 20, 40, false);//主体
                g.fill3DRect(x+30, y, 10, 60, false);//右轮
                g.fillOval(x+10, y+20, 20,20);//炮塔
                g.drawLine(x+20,y+30,x+20, y+60 );//炮筒
                break;
            case 3 ://左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x+10, y+10, 40, 20, false);
                g.fill3DRect(x, y+30, 60, 10, false);
                g.fillOval(x+20, y+10, 20,20);
                g.drawLine(x+30,y+20,x, y+20 );
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            myTank.setDirect(0);
            myTank.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirect(1);
            myTank.moveRight();
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirect(2);
            myTank.moveDown();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirect(3);
            myTank.moveLeft();
        }


        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
