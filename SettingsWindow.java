package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
private static final int WINDOW_WIDTH = 350;
private static final int WINDOW_HEIGHT = 270;
private static final int MIN_WIN_LENGTH = 3;
private static final int MIN_FIELD_SIZE = 3;
private static final int MAX_FIELD_SIZE = 10;
private static final String FIELD_SIZE_PREFIX = "Field size is: ";
private static final String WIN_LENGTH_PREFIX = "Win length is: ";

private GameWindow gameWindow;
private JRadioButton humVSAI;
private JRadioButton humVShum;
private JSlider slideWinLen;
private JSlider slideFieldSize;

        SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameControlsMode();
        addGameControlsField();
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
        btnStartClick();
        }
        });
        add(btnStart);
        }

private void addGameControlsMode() {
        add(new JLabel("Choose game mode"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
        }

private void addGameControlsField() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
@Override
public void stateChanged(ChangeEvent e) {
        int currentValue = slideFieldSize.getValue();
        lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
        slideWinLen.setMaximum(currentValue);
        }
        });
        slideWinLen.addChangeListener(new ChangeListener() {
@Override
public void stateChanged(ChangeEvent e) {
        lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
        }
        });
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
        }

private void btnStartClick() {
        int gameMode;
        if (humVSAI.isSelected()) {
        gameMode = FieldPanel.MODE_HVA;
        } else if (humVShum.isSelected()) {
        gameMode = FieldPanel.MODE_HVH;
        } else {
        throw new RuntimeException("Unexpected Spanish inquisition!");
        }
        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
        GameWindow.SetMap();
        }

}


