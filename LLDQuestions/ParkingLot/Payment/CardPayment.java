public class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Card payment was successful for amount: " + amount);
    }
}
