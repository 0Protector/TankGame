package com.yk.TankGame_;

import javax.swing.*;
import java.awt.*;

/**`
 * @author Tang
 * @version 1.0
 * 该项目并未完全实现，现只提供基本的地图绘制和我方坦克的移动
 * 后面会陆续完善
 */
public class tykTankGame_ extends JFrame{
    MyPanel_ myPanel = null;

    public static void main(String[] args) {

        tykTankGame_ tykTankGame_ = new tykTankGame_();
    }

    public tykTankGame_(){
        myPanel = new MyPanel_();
        this.add(myPanel);
        this.setSize(1000,750);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
