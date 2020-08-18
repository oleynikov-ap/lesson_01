package ru.geekbrains.java_one.lesson_g.online;

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
    private static final String FIELD_SIZE_X_PREFIX = "  Field size X is: ";
    private static final String FIELD_SIZE_Y_PREFIX = "  Field size Y is: ";
    private static final String WIN_LENGTH_PREFIX = "  Win length is: ";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JComboBox comboBoxFieldSizeX;
    private JComboBox comboBoxFieldSizeY;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(15, 1));
        addGameModeControls();
        addGameFieldControls();
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStart);
    }

    private void addGameModeControls() {
        add(new JLabel("  Choose game mode:"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
//        gameMode.add(humVSAI);
//        gameMode.add(humVShum);
        JPanel panelgameMode = new JPanel();
        panelgameMode.setLayout(new GridLayout(1, 2));
        panelgameMode.add(humVSAI);
        panelgameMode.add(humVShum);

        add(panelgameMode);
//        add(humVSAI);
//        add(humVShum);
    }

    private void addGameFieldControls() {
        JLabel lbFieldSizeX = new JLabel(FIELD_SIZE_X_PREFIX + MIN_FIELD_SIZE);
        JLabel lbFieldSizeY = new JLabel(FIELD_SIZE_Y_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        comboBoxFieldSizeX = new JComboBox();
        comboBoxFieldSizeX.setEnabled(true);
        for (int i = 3; i <= 10; i++) comboBoxFieldSizeX.addItem(i);
        comboBoxFieldSizeY = new JComboBox();
        comboBoxFieldSizeY.setEnabled(true);
        for (int i = 3; i <= 10; i++) comboBoxFieldSizeY.addItem(i);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        comboBoxFieldSizeX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = (int) comboBoxFieldSizeX.getSelectedItem();
                lbFieldSizeX.setText(FIELD_SIZE_X_PREFIX + currentValue);
                slideWinLen.setMaximum(Math.min(currentValue, (int) comboBoxFieldSizeY.getSelectedItem()));
            }
        });
        comboBoxFieldSizeY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = (int) comboBoxFieldSizeY.getSelectedItem();
                lbFieldSizeY.setText(FIELD_SIZE_Y_PREFIX + currentValue);
                slideWinLen.setMaximum(Math.min(currentValue, (int) comboBoxFieldSizeX.getSelectedItem()));
            }
        });
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(new JLabel("  Choose field X size"));
        add(lbFieldSizeX);
        add(comboBoxFieldSizeX);
        add(new JLabel("  Choose field Y size"));
        add(lbFieldSizeY);
        add(comboBoxFieldSizeY);
        add(new JLabel("  Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnStartClick() {
        int fieldSizeX = (int) comboBoxFieldSizeX.getSelectedItem();
        int fieldSizeY = (int) comboBoxFieldSizeY.getSelectedItem();
        int winLen = slideWinLen.getValue();

        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        gameWindow.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLen);
        setVisible(false);
    }
}
