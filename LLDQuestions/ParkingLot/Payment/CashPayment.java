package Payment;

public class CashPayment implements Payment{
    public void pay(double amount){
        System.out.println("Cash payment was successful for amount: " + amount); 
    }
}
