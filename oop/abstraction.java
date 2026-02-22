package oop;

// interface Animal {
//     abstract void makeSound();

//     static void drink() {
//         System.out.println("I need to dribk water to live.");
//     }

//     default void eat() {
//         System.out.println("I am animal/, and i eat to live");
//     }

// }

// interface CarniverousAnimal extends Animal {
//     void breed(boolean isCarniverousAnimal);

// }

// abstract class Lion implements CarniverousAnimal {
//     Lion() {
//     }

//     @Override
//     public void makeSound() {
//         System.out.println("I Roar");
//     }

//     @Override
//     public void breed(boolean isCarniverousAnimal) {
//         // TODO Auto-generated method stub

//     }

// }

abstract class Animal {
    String color;

    Animal(String color) {
        System.out.println("My color is " + color);
    }

    abstract void makeSound();

    static void drink(String animal) {
        System.out.println(animal + " drink water to live.");
    }

    void eat() {
        System.out.println("I am animal, and i eat to live");
    }

}

abstract class Lion extends Animal {

    Lion(String color) {
        super(color);
    }

    @Override
    void makeSound() {
        System.out.println("I Roar");
    }

    @Override
    void eat() {
        super.eat();
    }

}

public class abstraction {

    public static void main(String[] args) {
        Lion l1 = new Lion("Brown") {

        };
        Lion.drink("Lion");
        l1.eat();
        l1.makeSound();
        l1.drink("Tiger");

        System.out.println(l1 == l1);
    }
}