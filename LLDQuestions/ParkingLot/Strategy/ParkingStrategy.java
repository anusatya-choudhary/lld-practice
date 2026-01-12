package Strategy;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots);
}
