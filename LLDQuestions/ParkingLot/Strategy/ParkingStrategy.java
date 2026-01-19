package Strategy;

import java.util.List;
import Core.ParkingSpot;

public interface ParkingStrategy {
    ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots);
}
