package Level;

import java.util.List;
import Core.Vehicle;
import Core.VehicleType;
import Core.ParkingSpot;
import Core.Ticket;

public class ParkingBuilding {
    private List<ParkingLevel> parkingLevels;

    public ParkingBuilding(List<ParkingLevel> parkingLevels){
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocate(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels){
            VehicleType vehicleType = vehicle.getVehicleType();
            if(parkingLevel.hasAvailability(vehicleType)){
                ParkingSpot parkingSpot = parkingLevel.park(vehicleType);
                return new Ticket(vehicle, parkingLevel, parkingSpot);
            }
        }

        return null;
    }

    public void release(Ticket ticket){
        ParkingLevel parkingLevel = ticket.getParkingLevel();
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        parkingLevel.unpark(vehicleType, parkingSpot);
    }
}
