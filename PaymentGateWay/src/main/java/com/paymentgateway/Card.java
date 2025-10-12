package com.paymentgateway;

public abstract class Card implements PaymentMethod{
    private String cardNumber;
    private String userName;

    public Card(String cardNo, String name) {
        this.cardNumber = cardNo;
        this.userName = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    //abstract void pay();
}
