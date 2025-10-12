package com.paymentgateway;

import java.util.HashMap;

public class PaymentService {

    // Storing + Making payment
    HashMap<String, PaymentMethod> paymentMethods;

    public PaymentService() {
        paymentMethods = new HashMap<>();
    }

    public void addPaymentMethod(String paymentMethodName, PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethodName, paymentMethod);
    }

    public void makePayment(String paymentMethodName) {
        PaymentMethod paymentMethod = paymentMethods.get(paymentMethodName);
        paymentMethod.pay(); //RUNTIME POLYMORPHISM
    };
}
