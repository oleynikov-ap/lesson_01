package ru.geekbrains.lesson01.worker;

public class worker {
    private String FIO;
    private int age;
    private double pay;
    private static int numberWorker = 0;
    private final int id;

    worker(String FIO, int age, double pay){
        this.FIO = FIO;
        this.age = age;
        this.pay = pay;
//        setFIO(FIO);
//        setAge(age);
//        setPay(pay);
        id = ++numberWorker;
    }

    void setFIO(String FIO){this.FIO = FIO;}
    void setAge(int age){this.age = age;}
    void setPay(double pay){this.pay = pay;}

    String getFIO() {return FIO;}
    int getAge() {return age;}
    double getPay() {return pay;}
    int getId() {return id;};
    int getNumberWorker() {return numberWorker;}

    boolean isOlder(int age) {
        return (this.getAge() > age);
    }

    void payRise(int pay){
        this.pay += pay;
    }

    void payRise(int pay,int age){
//        if (isOlder(age)) this.pay += pay;
        if (isOlder(age)) payRise(pay);
    }
}
