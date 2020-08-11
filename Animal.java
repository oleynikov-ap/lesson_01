package zoo;

public abstract class Animal {
    protected String name;
    protected double height;
    protected int lengthRun;
    protected double lengthSwim;

    protected Animal(String name) {
        this.name = name;
    }

    protected Animal(String name, double height, int lengthRun, double lengthSwim) {
        this.height = height;
        this.lengthRun = lengthRun;
        this.lengthSwim = lengthSwim;
        this.name = name;
    }

    public void run(int lengthRun) {
        lengthRun = Math.min(lengthRun, this.lengthRun);
        if (lengthRun > 0) System.out.println(this.name + " пробежал " + lengthRun + " метров!");
        else System.out.println(this.name + " не умеет бегать!");
    }

    public void swim(double lengthSwim) {
        lengthSwim = Math.min(lengthSwim, this.lengthSwim);
        if (lengthSwim > 0) System.out.println(this.name + " проплыл " + lengthSwim + " метров!");
        else System.out.println(this.name + " не умеет плавать!");
    }

    public void jump(double height) {
        height = Math.min(height, this.height);
        if (height > 0) System.out.println(this.name + " прыгнул " + height + " метров в высоту!");
        else System.out.println(this.name + " не умеет прыгать!");
    }
}
