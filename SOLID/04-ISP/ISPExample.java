// Interface Segregation Principle (ISP) Example
// Clients should not be forced to depend on interfaces they don't use

// BAD EXAMPLE: Violating ISP
interface Worker {
    void work();
    void eat();
    void sleep();
}

class HumanBad implements Worker {
    @Override
    public void work(){
        System.out.println("Human is working...");
    }

    @Override
    public void eat(){
        System.out.println("Human is eating...");
    }

    @Override
    public void sleep(){
        System.out.println("Human is sleeping...");
    }
}

class RobotBad implements Worker {
    @Override
    public void work(){
        System.out.println("Robot is working...");
    }

    // Robots don't eat or sleep, violating ISP

    @Override
    public void eat(){
        throw new UnsupportedOperationException("Robots don't eat");
    }

    @Override
    public void sleep(){
        throw new UnsupportedOperationException("Robots don't sleep");
    }
}


// GOOD example : Following ISP

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Human implements Workable, Eatable, Sleepable {
    @Override
    public void work(){
        System.out.println("Human is working...");
    }

    @Override
    public void eat(){
        System.out.println("Human is eating...");
    }

    @Override
    public void sleep(){
        System.out.println("Human is sleeping...");
    }
}

class Robot implements Workable {
    @Override
    public void work(){
        System.out.println("Robot is working...");
    }
}

class WorkerService {
    public void work(Workable worker){
        worker.work();
    }
}

class LifeService {
    public void eat(Eatable worker){
        worker.eat();
    }

    public void sleep(Sleepable worker){
        worker.sleep();
    }
}

public class ISPExample {
    public static void main(String[] args) {
        
        Human human = new Human();
        Robot robot = new Robot();

        WorkerService workerService = new WorkerService();

        workerService.work(human);
        workerService.work(robot);

        LifeService lifeService = new LifeService();

        lifeService.eat(human);
        lifeService.sleep(human);

        // Will give error
        // lifeService.eat(robot);
    }
}