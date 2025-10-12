// Liskov Substitution Principle (LSP) Example
// Objects of a superclass should be replaceable with objects of its subclasses without breaking functionality

// BAD EXAMPLE: Violating LSP
class BirdBad {
    public void fly() {
        System.out.println("Bird is flying...");
    }
}

class EagleBad extends BirdBad {
    @Override
    public void fly() {
        System.out.println("Eagle is flying...");
    }
}

class PenguinBad extends BirdBad {
    @Override
    public void fly() {
        // LSP Violation : Penguin can't fly
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

//GOOD example : Following LSP

abstract class Bird {
    abstract void eat();
}

abstract class FlyingBird extends Bird {
    abstract void fly();
}

abstract class MarineBird extends Bird {
    abstract void swim();
}

class Eagle extends FlyingBird {
    @Override
    void fly() {
        System.out.println("Eagle is flying...");
    }

    @Override
    void eat() {
        System.out.println("Eagle is eating...");
    }
}

class Duck extends MarineBird{
    @Override
    void swim() {
        System.out.println("Duck is swimming...");
    }

    @Override
    void eat() {
        System.out.println("Duck is eating...");
    }
}

class BirdMigrationService {
    public void migrate(FlyingBird bird){
        System.out.println("Migration started...");
        bird.fly();
        System.out.println("Migration completed...");
        System.out.println("--------------------------------");
    }
}

class AquariumFeedingService {
    public void feed(MarineBird bird){
        System.out.println("Feeding started...");
        bird.swim();
        bird.eat();
        System.out.println("Feeding completed...");
        System.out.println("--------------------------------");
    }
}

public class LSPExample {
    public static void main(String[] args) {
        //Individual birds
        Eagle eagle = new Eagle();
        Duck duck = new Duck();

        BirdMigrationService birdMigrationService = new BirdMigrationService();
        birdMigrationService.migrate(eagle);

        AquariumFeedingService aquariumFeedingService = new AquariumFeedingService();
        aquariumFeedingService.feed(duck);
    }
}
