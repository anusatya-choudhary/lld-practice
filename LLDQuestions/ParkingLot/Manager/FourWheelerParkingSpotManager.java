package Manager;

import java.util.List;
import Strategy.ParkingStrategy;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        super(parkingSpots, parkingStrategy);
    }
}
