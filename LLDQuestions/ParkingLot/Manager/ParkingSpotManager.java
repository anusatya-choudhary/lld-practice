package Manager;

import java.util.List;
import Strategy.ParkingStrategy;

public abstract class ParkingSpotManager {
    private List<ParkingSpot> parkingSpots;
    private ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot park(){
        ParkingSpot parkingSpot = parkingStrategy.selectParkingSpot(parkingSpots);
        if(parkingSpot == null){
            throw new IllegalStateException("No parking spots available");
        }
        parkingSpot.occupySpot();
        return parkingSpot;
    }

    public void unpark(ParkingSpot spot){
        spot.releaseSpot();
    }

    public boolean hasFreeParkingSpot(){
        boolean hasFreeSpot = false;
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isEmpty()){
                hasFreeSpot = true;
                break;
            }
        }
        return hasFreeSpot;
    }
}
