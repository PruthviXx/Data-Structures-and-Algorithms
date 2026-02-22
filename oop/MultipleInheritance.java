class Animal {
    void eat() {
        System.out.println("Lion is eating");
    }
}

class CarniverousAnimal extends Animal {
    void drink() {
        System.out.println("Lion is drink");
    }

    @Override
    void eat() {
        System.out.println("CarniverousAnimal is eating");
        super.eat();
    }
}

class Lion extends CarniverousAnimal {

    @Override
    void eat() {
        super.eat();
    }

    @Override
    void drink() {
        super.drink();
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Lion l1 = new Lion();
        l1.eat();
        l1.drink();
    }
}
