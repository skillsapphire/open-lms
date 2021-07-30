package com.open.lms.service.payment.impl;

import com.open.lms.model.PaymentMethod;
import com.open.lms.service.payment.PaymentService;
import com.paypal.api.payments.Payment;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

@Service
public class StripeService implements PaymentService {
    @Override
    public Payment createPayment(Money finalPrice) {
        return null;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.STRIPE;
    }

    @Override
    public void completePayment(String paymentId, String payerId) {

    }
}
