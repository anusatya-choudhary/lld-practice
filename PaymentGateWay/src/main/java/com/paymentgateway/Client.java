package com.paymentgateway;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.addPaymentMethod("Anusatya_Credit_Card", new CreditCard("1234567890", "Anusatya"));
        paymentService.addPaymentMethod("Anusatya_Debit_Card", new DebitCard("1234567890", "Anusatya"));
        paymentService.addPaymentMethod("Anusatya_UPI", new UPI("Anusatya123"));
        paymentService.addPaymentMethod("Anusatya_Wallet", new Wallet());
        
        paymentService.makePayment("Anusatya_Credit_Card");
        paymentService.makePayment("Anusatya_Debit_Card");
        paymentService.makePayment("Anusatya_UPI");
        paymentService.makePayment("Anusatya_Wallet");
    }
}


