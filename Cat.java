package zoo;

import zoo.Animal;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
        this.height = 2;
        this.lengthRun = 200;
        this.lengthSwim = 0;
    }
    public Cat(String name, double height, int lengthRun, double lengthSwim) {
        super(name, height, lengthRun, lengthSwim);
    }
}
