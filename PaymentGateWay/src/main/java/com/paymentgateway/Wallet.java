package com.paymentgateway;

public class Wallet implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Making payment from Wallet");
    }
}
