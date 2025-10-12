package com.paymentgateway;

public class CreditCard extends Card {
    public CreditCard(String cardNo, String name) {
        // Constructor of parent class is called ie Card class
        super(cardNo, name);
    }

    @Override
    public void pay() {
        System.out.println("Credit card payment - " + getCardNumber() + "/" + getUserName());
    }
}
