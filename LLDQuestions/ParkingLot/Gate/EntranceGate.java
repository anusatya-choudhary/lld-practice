package Gate;

import Core.Ticket;
import Core.Vehicle;
import Level.ParkingBuilding;

public class EntranceGate {
    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle){
        Ticket ticket = parkingBuilding.allocate(vehicle);
        if(ticket == null){
            throw new IllegalStateException("No parking spots available");
        }
        return ticket;
    }
}
