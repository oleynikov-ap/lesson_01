package ru.geekbrains.lesson01.TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int numberChips;
    private static char[][] field;

    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        numberChips = 4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn(int[] arr) {
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            arr[0] = SCANNER.nextInt() - 1;
            arr[1] = SCANNER.nextInt() - 1;
        } while (!isValidCell(arr[0], arr[1]) || !isEmptyCell(arr[0], arr[1]));
        field[arr[1]][arr[0]] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    // ход компьютера...
    private static void aiTurn(int[] arr) {
        int summAI = 0, summHuman = 0;
        int[] humanTmp = new int[2];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isEmptyCell(x, y)) {
                    summAI = getSummChips(DOT_AI, arr, summAI, x, y, 0,1);
                    summAI = getSummChips(DOT_AI, arr, summAI, x, y, 1,0);
                    summAI = getSummChips(DOT_AI, arr, summAI, x, y, 1,1);
                    summAI = getSummChips(DOT_AI, arr, summAI, x, y, 1,-1);
                    summHuman = getSummChips(DOT_HUMAN, humanTmp, summHuman, x, y, 0,1);
                    summHuman = getSummChips(DOT_HUMAN, humanTmp, summHuman, x, y, 1,0);
                    summHuman = getSummChips(DOT_HUMAN, humanTmp, summHuman, x, y, 1,1);
                    summHuman = getSummChips(DOT_HUMAN, humanTmp, summHuman, x, y, 1,-1);
                    if (summHuman > summAI) {
                        arr[0] = humanTmp[0];
                        arr[1] = humanTmp[1];
                    }
                }
            }
        }
        field[arr[1]][arr[0]] = DOT_AI;
    }

    private static int getSummChips(char c, int[] arr, int summAI, int x, int y, int sign1, int sign2) {
        int summTemp;
        summTemp = checkLine2(c, x, y, sign1, sign2) + checkLine2(c, x, y, -sign1, -sign2);
        if (summTemp > summAI) {
            arr[0] = x;
            arr[1] = y;
            return summTemp;
        }
        else return summAI;
    }

    //    первый вариант проверки линии.
    //    не учитывается последний ход игрока.

    private static boolean checkLine(char c, int x, int y, int signX, int signY) {
        int valNumber = 0;
        while (valNumber < numberChips && field[x + signX * valNumber][y + signY * valNumber] == c) valNumber++;
        return valNumber == numberChips;
    }
    private static boolean checkWin(char c) {
        // ver
        for (int x = 0; x < fieldSizeX; x++)
            for (int y =0; y <= fieldSizeY - numberChips; y++)
                if (checkLine(c, x, y, 0,1)) return true;
        // hor
        for (int y = 0; y < fieldSizeY; y++)
            for (int x = 0; x <= fieldSizeX - numberChips; x++)
                if (checkLine(c, x, y, 1,  0)) return true;
        // dia - rigth
        for (int x = 0; x <= fieldSizeX - numberChips; x++)
            for (int y = 0; y <= fieldSizeY - numberChips; y++)
                if (checkLine(c, x, y, 1,  1)) return true;
        // dia - left
        for (int y = numberChips - 1; y < fieldSizeX; y++)
            for (int x = 0; x <= fieldSizeX - numberChips; x++)
                if (checkLine(c, x, y, 1,  -1)) return true;
        return false;
    }
    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    //    второй вариант проверки линии.
    //    проверка от последнего хода игрока.
    private static int checkLine2(char c, int x, int y, int signX, int signY) {
        int valNumber = 1;
        int xChips = x + signX * valNumber;
        int yChips = y + signY * valNumber;
        while (isValidCell(xChips, yChips) && field[yChips][xChips] == c) {
            valNumber++;
            xChips = x + signX * valNumber;
            yChips = y + signY * valNumber;
        }
        return valNumber - 1;
    }
    private static boolean checkWin2(char c, int arr[], int numberMatches) {
        if (checkLine2(c, arr[0], arr[1],0,1) + checkLine2(c, arr[0], arr[1],0,-1) >= numberMatches) return true;
        if (checkLine2(c, arr[0], arr[1],1,0) + checkLine2(c, arr[0], arr[1],-1,0) >= numberMatches) return true;
        if (checkLine2(c, arr[0], arr[1], 1, 1) + checkLine2(c, arr[0], arr[1], -1,  -1) >= numberMatches) return true;
        if (checkLine2(c, arr[0], arr[1], 1, -1) + checkLine2(c, arr[0], arr[1], -1,  1) >= numberMatches) return true;
        return false;
    }
    private static boolean checkEndGame(char dot, String winMessage,int[] arr) {
        printField();
        if (checkWin2(dot, arr, numberChips - 1)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String answer;
        int[] human = new int[2];
        int[] ai = new int[2];
        do {
            initField();
            printField();
            while (true) {
                humanTurn(human);
                if (checkEndGame(DOT_HUMAN, "Human win!",human)) break;
                aiTurn(ai);
                if (checkEndGame(DOT_AI, "Computer win!",ai)) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

}