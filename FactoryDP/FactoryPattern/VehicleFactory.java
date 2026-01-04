public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        switch (vehicleType) {

            case "car":
                return new Car();

            case "bike":
                return new Bike();

            case "truck":
                return new Truck();

            default:
                throw new IllegalArgumentException("Incorrect vehicle type: " + vehicleType);
        }
    }
}
