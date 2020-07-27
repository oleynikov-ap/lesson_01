package ru.geekbrains.lab1;

public class Main {

    public static void main(String[] args) {
	// write your code here
    byte b0 = 7;
    short s0 = 300;
    int i0 = 100000;
    long l0 = 10000000000L;
    char ch = 'A';
    float f1 = 1.23f;
    double d1 = 456.78;
    boolean val = true;
    }

    public static float calculate(float a,float b,float c,float d){
        return a * (b + c / d);
    }

    public static boolean range10And20(int a, int b){
        int c = a + b;
        return (c >= 10) && (c <= 20);
    }

    public static void isPositive(int x){
        if (x >= 0) System.out.println("Число: " + x + " - положительное");
        else System.out.println("Число: " + x + " - отрицательное");
    }

    public static boolean isNegative(int x){
        return x < 0;
    }
    public static void helloName(String str){
        System.out.println("Привет, " + str + "!");
    }

    public static void leapYear(int x){
        if (((x % 4 == 0) && (x % 100 != 0)) || (x % 400 == 0)) System.out.println(x + " год - високосный");
        else System.out.println(x + "год не является високосным");
    }
}
