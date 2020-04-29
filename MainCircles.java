package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    BackGround Bg = new BackGround();
    Sprite[] sprites = new Sprite[100];
    private  static int b = 10;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }
    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        BackGround Bg = new BackGround();
        JButton btnAdd = new JButton("Добавить кружок");
        JButton btnDel = new JButton("Удалить");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        initApplication();
        setVisible(true);
        JPanel pBtns = new JPanel(new GridLayout(1, 2));
        pBtns.add(btnAdd);
        pBtns.add(btnDel);
        add(pBtns, BorderLayout.SOUTH);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = b+1;
            }
        };
                btnAdd.addActionListener(listener);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = b-1;
            }
        };
        btnDel.addActionListener(listener1);
    }
    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        Bg.update(canvas,deltaTime);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g) {
        Bg.render(canvas,g);
        for (int i = 0; i < b; i++) {
            sprites[i].render(canvas, g);
        }
    }


}