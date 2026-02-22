package oop;

interface Animal {
    void eat();
}

interface CarniverousAnimal extends Animal {
    void drink();
}

class Lion implements CarniverousAnimal {

    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void drink() {
        System.out.println("Lion is drinking water");
    }

}

public class Interfaces {
    public static void main(String[] args) {
        Lion l1 = new Lion();
        l1.eat();
        l1.drink();
    }
}
