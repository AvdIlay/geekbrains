package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;
    private static Map map;
    private FieldPanel fieldPanel;
    private SettingsWindow settingsWindow;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setTitle("Tic tac toe");
        setResizable(false);
        JButton btnStart = new JButton("Start new game");
        JButton btnStop = new JButton("<html><body><b>Exit</b></body></html>");
        settingsWindow = new SettingsWindow(this);
        map = new Map(this);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        };
        btnStart.addActionListener(listener);


        JPanel pBtns = new JPanel(new GridLayout(1, 2));
        pBtns.add(btnStart);
        pBtns.add(btnStop);
        fieldPanel = new FieldPanel();

        add(pBtns, BorderLayout.SOUTH);
        add(fieldPanel);
        setVisible(true);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        fieldPanel.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
    public static void SetMap(){
        map.setVisible(true);

    }

}

