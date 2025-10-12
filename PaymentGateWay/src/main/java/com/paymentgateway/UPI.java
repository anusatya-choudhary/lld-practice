package com.paymentgateway;

public class UPI implements PaymentMethod {

    private String upiId;

    public UPI(String id) {
        this.upiId = id;
    }

    public String getUpiId() {
        return upiId;
    }

    @Override
    public void pay() {
        System.out.println("UPI payment - " + getUpiId());
    }
}
