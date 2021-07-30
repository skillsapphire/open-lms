package com.open.lms.service.payment;

import com.open.lms.model.PaymentMethod;
import com.paypal.api.payments.Payment;
import org.javamoney.moneta.Money;

public interface PaymentService {
    Payment createPayment(Money finalPrice, PaymentConfig paymentConfig);

    PaymentMethod getPaymentMethod();

    void completePayment(String paymentId, String payerId, PaymentConfig paymentConfig);
}
