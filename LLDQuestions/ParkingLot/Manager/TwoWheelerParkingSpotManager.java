package Manager;

import java.util.List;
import Strategy.ParkingStrategy;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{
    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        super(parkingSpots, parkingStrategy);
    }
}
