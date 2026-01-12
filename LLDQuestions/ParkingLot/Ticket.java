import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private ParkingLevel parkingLevel;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot){
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
