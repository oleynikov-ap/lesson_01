package zoo;

import zoo.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.height = 0.5;
        this.lengthRun = 500;
        this.lengthSwim = 10;
    }
    public Dog(String name, double height, int lengthRun, double lengthSwim) {
        super(name, height, lengthRun, lengthSwim);
    }
}
