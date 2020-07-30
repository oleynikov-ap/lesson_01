package ru.geekbrains.lesson01.lab2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        первое задание
//        int[] arr11 = {1,1,1,0,0,0,1,0,1,1};
//        int[] arr12 = {1,1,0,1,0,1,1};
//        invertArrayFirst(arr1);
//        System.out.println(Arrays.toString(arr1));
//        invertArraySecond(arr2);
//        System.out.println(Arrays.toString(arr2));

//        второе задание
//        int[] arr2 = new int[8];
//        fillArray(arr2);
//        System.out.println(Arrays.toString(arr2));

//        третье задание
//        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        changeArray(arr3);
//        System.out.println(Arrays.toString(arr3));

//        четвертое задание
//        int[] arr4 = {4, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(Arrays.toString(arr4));
//        System.out.println("Минимальный элемент массива: " + minElement(arr4));
//        System.out.println("Максимальный элемент массива: " + maxElement(arr4));

//        пятое задание
//        int [][] arr5 = new int[5][5];
//        fillDiagonals(arr5);
//        for (int i = 0; i < arr5.length; i++)
//            System.out.println(Arrays.toString(arr5[i]));

//        шестое задание
//        int[] arr61 = {1, 1, 1, 2, 1};
//        int[] arr62 = {2, 1, 1, 2, 1};
//        int[] arr63 = {10, 1, 2, 3, 4};
//        System.out.println(checkBalance(arr61));
//        System.out.println(checkBalance(arr62));
//        System.out.println(checkBalance(arr63));

//        седьмое задание
        int [] arr7 = {1,2,3,4,5,6,7,8};
        changeArray(arr7,4);
        System.out.println(Arrays.toString(arr7));
    }
//    Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в
//    принятом массиве 0 на 1, 1 на 0;
    private static void invertArrayFirst(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }
    private static void invertArraySecond(int[] arr){
        for (int i = 0; i < arr.length; i++) arr[i] = (arr[i] == 0) ? 1 : 0;
    }
//    Задать пустой целочисленный массив размером 8. Написать метод, который
//    c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22.
    private static void fillArray(int[] arr){
        for (int i = 0; i < arr.length; i++) arr[i] = i * 3 + 1;
    }
//    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
//    принимающий на вход массив и умножающий числа меньше 6 на 2;
    private static void changeArray(int[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6) arr[i] *= 2;
    }
//    Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента
    private static int minElement(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < result) result = arr[i];
        return result;
    }
    private static int maxElement(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > result) result = arr[i];
        return result;
    }
//    Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
//    заполнить его диагональные элементы единицами, используя цикл(ы)
    private static void fillDiagonals(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if ((i == j) || (len - i - 1 == j)) arr[i][j] = 1;
                else arr[i][j] = i + j;
    }
//    Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true если в массиве есть место, в котором сумма левой и
//    правой части массива равны. Примеры: checkBalance([1, 1, 1, 2, 1]) → true,
//    checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true.
    private static boolean checkBalance(int[] arr){
        int i = 0, j = arr.length - 1;
        int summLeft = 0, summRigth = 0;
        while (i <= j){
            if (summLeft > summRigth) summRigth += arr[j--];
            else summLeft += arr[i++];
        }
        return  summLeft == summRigth;
    }
//    Написать метод, которому на вход подается одномерный массив и
//    число n (может быть положительным, или отрицательным), при этом метод
//    должен сместить все элементымассива на n позиций. Для усложнения задачи
//    нельзя пользоваться вспомогательными массивами.
    private static void changeArray(int[] arr, int n){
        int len = arr.length;
        n = n % len;
        if (n < 0) n = len + n;
        for (int i = 0; i < n; i++) changeArrayStepRigth(arr);
    }
//    вспомогательный метод сдвигает элементы массива на одну позицию
    private static void changeArrayStepRigth(int[] arr){
        int tmp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) arr[i] = arr[i + 1];
        arr[arr.length - 1] = tmp;
    }
}
