public class ExitGate {
    private CostComputation costComputation;

    public ExitGate(CostComputation costComputation){
        this.costComputation = costComputation;
    }

    public void exit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment){
        double cost  = costComputation.compute(ticket);
        payment.pay(cost);
        parkingBuilding.release(ticket);
    }
}
