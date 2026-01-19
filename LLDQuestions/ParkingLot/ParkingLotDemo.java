import java.util.*;

import Manager.TwoWheelerParkingSpotManager;
import Manager.FourWheelerParkingSpotManager;
import Strategy.LinearParkingStrategy;
import Strategy.NearestToGateParkingStrategy;

public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("=== Parking Lot System Demo ===\n");

        // Setup: Create parking spots
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            twoWheelerSpots.add(new ParkingSpot(i));
        }

        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            fourWheelerSpots.add(new ParkingSpot(i));
        }

        // Setup: Create parking strategies
        ParkingStrategy linearStrategy = new LinearParkingStrategy();
        ParkingStrategy nearestStrategy = new NearestToGateParkingStrategy();

        // Setup: Create parking spot managers
        TwoWheelerParkingSpotManager twoWheelerManager = 
            new TwoWheelerParkingSpotManager(twoWheelerSpots, nearestStrategy);
        
        FourWheelerParkingSpotManager fourWheelerManager = 
            new FourWheelerParkingSpotManager(fourWheelerSpots, linearStrategy);

        // Setup: Create parking level with managers
        Map<VehicleType, Manager.ParkingSpotManager> spotManagers = new HashMap<>();
        spotManagers.put(VehicleType.TWO_WHEELER, twoWheelerManager);
        spotManagers.put(VehicleType.FOUR_WHEELER, fourWheelerManager);

        ParkingLevel level1 = new ParkingLevel(1, spotManagers);

        // Setup: Create parking building with levels
        List<ParkingLevel> levels = new ArrayList<>();
        levels.add(level1);
        ParkingBuilding building = new ParkingBuilding(levels);

        // Setup: Create pricing strategy and cost computation
        PricingStrategy hourlyPricing = new HourlyRateStrategy();
        CostComputation costComputation = new CostComputation(hourlyPricing);

        // Setup: Create gates
        EntranceGate entranceGate = new EntranceGate();
        ExitGate exitGate = new ExitGate(costComputation);

        // Setup: Create parking lot
        ParkingLot parkingLot = new ParkingLot(building, entranceGate, exitGate);

        // Demo: Vehicle 1 - Two Wheeler arrives
        System.out.println("--- Scenario 1: Two Wheeler Arrives ---");
        Vehicle bike1 = new Vehicle("BIKE-001", VehicleType.TWO_WHEELER);
        Ticket ticket1 = parkingLot.vehicleArrives(bike1);
        System.out.println("Vehicle " + bike1.getVehicleNumber() + " parked at Level " + 
            ticket1.getParkingLevel().getLevelNumber() + ", Spot " + ticket1.getParkingSpot().getSpotId());
        System.out.println("Entry Time: " + ticket1.getEntryTime());
        System.out.println();

        // Demo: Vehicle 2 - Four Wheeler arrives
        System.out.println("--- Scenario 2: Four Wheeler Arrives ---");
        Vehicle car1 = new Vehicle("CAR-001", VehicleType.FOUR_WHEELER);
        Ticket ticket2 = parkingLot.vehicleArrives(car1);
        System.out.println("Vehicle " + car1.getVehicleNumber() + " parked at Level " + 
            ticket2.getParkingLevel().getLevelNumber() + ", Spot " + ticket2.getParkingSpot().getSpotId());
        System.out.println("Entry Time: " + ticket2.getEntryTime());
        System.out.println();

        // Demo: Vehicle 1 exits with Cash Payment
        System.out.println("--- Scenario 3: Two Wheeler Exits with Cash Payment ---");
        try {
            Thread.sleep(2000); // Simulate 2 seconds of parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment cashPayment = new CashPayment();
        System.out.println("Calculating cost...");
        double cost1 = costComputation.compute(ticket1);
        System.out.println("Total Cost: Rs " + cost1);
        parkingLot.vehicleExits(ticket1, cashPayment);
        System.out.println("Vehicle " + bike1.getVehicleNumber() + " has exited.");
        System.out.println();

        // Demo: Vehicle 2 exits with UPI Payment
        System.out.println("--- Scenario 4: Four Wheeler Exits with UPI Payment ---");
        try {
            Thread.sleep(1000); // Simulate 1 more second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment upiPayment = new UPIPayment();
        System.out.println("Calculating cost...");
        double cost2 = costComputation.compute(ticket2);
        System.out.println("Total Cost: Rs " + cost2);
        parkingLot.vehicleExits(ticket2, upiPayment);
        System.out.println("Vehicle " + car1.getVehicleNumber() + " has exited.");
        System.out.println();

        // Demo: Test with Fixed Rate Strategy
        System.out.println("--- Scenario 5: Testing Fixed Rate Pricing Strategy ---");
        Vehicle bike2 = new Vehicle("BIKE-002", VehicleType.TWO_WHEELER);
        Ticket ticket3 = parkingLot.vehicleArrives(bike2);
        System.out.println("Vehicle " + bike2.getVehicleNumber() + " parked.");
        
        // Change pricing strategy to Fixed Rate
        PricingStrategy fixedPricing = new FixedRateStrategy();
        CostComputation fixedCostComputation = new CostComputation(fixedPricing);
        ExitGate exitGateFixed = new ExitGate(fixedCostComputation);
        ParkingLot parkingLotFixed = new ParkingLot(building, entranceGate, exitGateFixed);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Payment cardPayment = new CardPayment();
        System.out.println("Calculating cost with Fixed Rate...");
        double cost3 = fixedCostComputation.compute(ticket3);
        System.out.println("Total Cost: Rs " + cost3);
        parkingLotFixed.vehicleExits(ticket3, cardPayment);
        System.out.println("Vehicle " + bike2.getVehicleNumber() + " has exited.");
        System.out.println();

        System.out.println("=== Demo Complete ===");
    }
}
