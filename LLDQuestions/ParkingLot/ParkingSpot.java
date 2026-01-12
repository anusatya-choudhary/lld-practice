public class ParkingSpot {
    private boolean isEmpty;
    private int spotId;

    public ParkingSpot(int spotId) {
        this.isEmpty = true;
        this.spotId = spotId;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void occupySpot() {
        this.isEmpty = false;
    }

    public void releaseSpot() {
        this.isEmpty = true;
    }

    public int getSpotId() {
        return spotId;
    }
}
