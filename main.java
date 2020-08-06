package ru.geekbrains.lesson01.worker;

public class main {
    public static void main(String[] args) {
        worker[] work = new worker[5];
        work[0] = new worker("Иванов Иван Иванович",47,50000);
        work[1] = new worker("Петров Василий Иванович",45,40000);
        work[2] = new worker("Васильев Петр Михайлович",41,45000);
        work[3] = new worker("Попов Максим Викторович",46,45000);
        work[4] = new worker("Максимов Иван Кузьмич",40,50000);

        for (int i = 0; i < work.length; i++)
            System.out.println(work[i].getId() + ". " + work[i].getFIO() + ". Возраст: " + work[i].getAge() + " лет. Зарплата: " + work[i].getPay());
        System.out.println("Количество сотрудников: " + work[0].getNumberWorker());

        int age = 40;
        System.out.println("Сотрудники старше " + age + " лет:");
        for (int i = 0; i < work.length; i++)
            if (work[i].isOlder(age))
                System.out.println(work[i].getFIO() + ". Возраст: " + work[i].getAge());

        age = 45;
        int pay = 5000;
        System.out.println("Повышение зарплаты на " + pay + " для сотрудников старше " + age + " лет:");
        for (int i = 0; i < work.length; i++) {
            work[i].payRise(pay, age);
//            System.out.println(work[i].getFIO() + ". Возраст: " + work[i].getAge() + " лет. Зарплата: " + work[i].getPay());
//            if (work[i].isOlder(age)) work[i].payRise(pay);
//            System.out.println(work[i].getFIO() + ". Возраст: " + work[i].getAge() + " лет. Зарплата: " + work[i].getPay());
        }
        double payMiddle = 0, ageMiddle = 0;
        for (int i = 0; i < work.length; i++) {
            payMiddle += work[i].getPay();
            ageMiddle += work[i].getAge();
        }
        payMiddle /= work.length;
        ageMiddle /= work.length;
        System.out.println("Средняя зарплата: " + payMiddle + ". Средний возраст: " + ageMiddle + ".");
    }
}
