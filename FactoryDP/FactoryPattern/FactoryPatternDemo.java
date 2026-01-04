public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demo ===\n");

        Vehicle vehicle1  = VehicleFactory.createVehicle("car");
        Vehicle vehicle2  = VehicleFactory.createVehicle("bike");
        Vehicle vehicle3  = VehicleFactory.createVehicle("truck");

        System.out.println("Vehicle 1: " + vehicle1.getType());
        vehicle1.drive();
        System.out.println();

        System.out.println("Vehicle 2: " + vehicle2.getType());
        vehicle2.drive();
        System.out.println();

        System.out.println("Vehicle 3: " + vehicle3.getType());
        vehicle3.drive();
        System.out.println();

        System.out.println("=== Factory Pattern Demo Ended ===\n");
    }
}
