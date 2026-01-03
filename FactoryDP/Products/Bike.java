public class Bike implements Vehicle {
    @Override
    public void drive(){
        System.out.println("Driving a bike...");
    }

    public String getType(){
        return "Bike";
    }
}
