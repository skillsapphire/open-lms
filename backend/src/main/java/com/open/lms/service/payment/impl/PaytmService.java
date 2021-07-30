package com.open.lms.service.payment.impl;

import com.open.lms.model.PaymentMethod;
import com.open.lms.service.payment.PaymentConfig;
import com.open.lms.service.payment.PaymentService;
import com.paypal.api.payments.Payment;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

@Service
public class PaytmService implements PaymentService {
    @Override
    public Payment createPayment(Money finalPrice, PaymentConfig paymentConfig) {
        return null;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.PAYTM;
    }

    @Override
    public void completePayment(String paymentId, String payerId, PaymentConfig paymentConfig) {

    }
}
