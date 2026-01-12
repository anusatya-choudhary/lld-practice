package Strategy;

import java.util.List;

public class NearestToGateParkingStrategy implements ParkingStrategy {
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots){
        ParkingSpot nearestSpot = null;
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isEmpty()){
                if(nearestSpot == null){
                    nearestSpot = parkingSpot;
                }else if(nearestSpot.getSpotId() > parkingSpot.getSpotId()){
                    nearestSpot = parkingSpot;
                }
            }
        }
        return nearestSpot;
    }
}
