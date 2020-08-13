package ru.geekbrains.lesson01.lab6;

import java.io.*;
import java.util.Scanner;

public class main {
    public static void appendFile(String name1, String name2) throws IOException {
        FileOutputStream fos = new FileOutputStream(name1, true);
        FileInputStream fis = new FileInputStream(name2);
        int b;
        while ( (b = fis.read()) != -1 )
           fos.write((char) b);
        fos.flush();
        fos.close();
        fis.close();
    }

    public static void joinFile(String name1, String name2, String name3)  throws IOException  {
        appendFile(name3, name1);
        appendFile(name3,name2);
    }

    public static boolean findWord(String fileName, String word) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        int b;
        int len = 0, length = word.length();
        char[] w = word.toCharArray();
        while ((b = fis.read()) != -1 ) {
            if ((char) b == ' ' && len == length) {
                fis.close();
                return true;
            }
            if ((char) b == w[len]) len++;
            else len = 0;
        }
        fis.close();
        return false;
    }

    public static boolean findWordInFolder(String folderName, String word) throws IOException {
        File f = new File(folderName);
        File[] fList = f.listFiles();
        for (int i = 0; i < fList.length; i++) {
            if (fList[i].isFile()) {
                if (findWord(fList[i].getPath(),word)) return true;
            }
            else if (findWordInFolder(fList[i].getPath(), word)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            String nameFile = "test1.txt", word1 = "been", folderName = "c:/test";
            joinFile("test1.txt", "test2.txt","test3.txt");
            if (findWord(nameFile, word1))
                System.out.println("В файле " + nameFile + "есть слово " + "'" + word1 + "'");
            else System.out.println("В файле " + nameFile + "нет слова " + "'" + word1 + "'");;

            if (findWordInFolder(folderName, word1))
                System.out.println("В папке " + folderName + " во вложенных файлах есть слово " + "'" + word1 + "'");
            else System.out.println("В папке " + folderName + " во вложенных файлах нет слова " + "'" + word1 + "'");;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
