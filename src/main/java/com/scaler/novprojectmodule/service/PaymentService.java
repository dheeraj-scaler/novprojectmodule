package com.scaler.novprojectmodule.service;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String makePayment(String orderId, Long amount) throws StripeException;
}
