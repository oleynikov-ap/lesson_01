package ru.geekbrains.java_one.lesson_g.online;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    public int lineCountX;
    public int lineCountY;
    private GameWindow gameWindow;

    Map() {
        setBackground(Color.DARK_GRAY);
    }
    Map(int lineCount) {
        setBackground(Color.DARK_GRAY);
        this.lineCountX = lineCount;
        this.lineCountY = lineCount;
    }

    Map(int lineCountX, int lineCountY) {
        setBackground(Color.DARK_GRAY);
        this.lineCountX = lineCountX;
        this.lineCountY = lineCountY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.white);
        g.setColor(Color.BLACK);
        int cellWidth = getWidth() / lineCountX;
        int cellHeight = getHeight() / lineCountY;
        for (int i = 0; i < lineCountX; i++)
            for (int j = 0; j < lineCountY; j++) {
                g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
    }
}
