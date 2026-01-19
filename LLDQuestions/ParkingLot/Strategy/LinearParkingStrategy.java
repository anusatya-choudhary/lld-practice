package Strategy;

import java.util.List;
import Core.ParkingSpot;

public class LinearParkingStrategy implements ParkingStrategy {
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isEmpty()){
                return parkingSpot;
            }
        }
        return null;
    }
}
