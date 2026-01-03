public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demo ===\n");

        // Create vehicles using a factory
        // Client doesn't deal with concrete vehicle classes
        Vehicle car = VehicleFactory.createVehicle("car");
        Vehicle bike = VehicleFactory.createVehicle("bike");
        Vehicle truck = VehicleFactory.createVehicle("truck");

        System.out.println("Vehicle 1: " + car.getType());
        car.drive();
        System.out.println();

        System.out.println("Vehicle 2: " + bike.getType());
        bike.drive();
        System.out.println();

        System.out.println("Vehicle 3: " + truck.getType());
        truck.drive();

        System.out.println("\nAll vehicles created successfully!");
    }
}
