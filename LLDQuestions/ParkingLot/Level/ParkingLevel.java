package Level;

import java.util.Map;
import Manager.ParkingSpotManager;
import Core.VehicleType;
import Core.ParkingSpot;

public class ParkingLevel {
    private int levelNumber;
    private Map<VehicleType, ParkingSpotManager> parkingSpotManagers;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> parkingSpotManagers) {
        this.levelNumber = levelNumber;
        this.parkingSpotManagers = parkingSpotManagers;
    }

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicleType);
        if (parkingSpotManager == null) {
            throw new IllegalArgumentException("Invalid vehicle type for this level");
        }
        return parkingSpotManager.hasFreeParkingSpot();
    }

    public ParkingSpot park(VehicleType vehicleType) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicleType);
        if (parkingSpotManager == null) {
            throw new IllegalArgumentException("Invalid vehicle type for this level");
        }
        return parkingSpotManager.park();
    }

    public void unpark(VehicleType vehicleType, ParkingSpot spot) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicleType);
        if (parkingSpotManager == null) {
            throw new IllegalArgumentException("Invalid vehicle type for this level");
        }
        parkingSpotManager.unpark(spot);
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
