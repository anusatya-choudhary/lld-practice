package com.paymentgateway;

public class DebitCard extends Card {
    public DebitCard(String cardNo, String name) {
        // Constructor of parent class is called ie Card class
        super(cardNo, name);
    }

    @Override
    public void pay() {
        System.out.println("Debit card payment - " + getCardNumber() + "/" + getUserName());
    }
}
