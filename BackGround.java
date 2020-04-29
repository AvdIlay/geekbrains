package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BackGround extends JPanel {
    float a=0;
    int b=10;
    BackGround(){ }
    void update(GameCanvas canvas, float deltaTime) {
        a=deltaTime*500;
       if (a>10) {
           b=b+1;
           if (b>240)
           { b=0;
           }
           Color Bg = new Color ((int)(Math.random() * 255),
                   b,(int)(Math.random() * 255));
           setBackground(Bg);

       }
    }
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(getBackground());
        g.fillRect(canvas.getX(),canvas.getY(), canvas.getWidth(), canvas.getHeight());



    }
}
