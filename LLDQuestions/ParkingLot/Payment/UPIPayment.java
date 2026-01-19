public class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("UPI payment was successful for amount: " + amount);
    }
}
