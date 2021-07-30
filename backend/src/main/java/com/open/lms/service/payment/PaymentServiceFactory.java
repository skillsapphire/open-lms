package com.open.lms.service.payment;

import com.open.lms.model.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceFactory {

    private final Map<PaymentMethod, PaymentService> paymentMethodServiceCache = new EnumMap<>(PaymentMethod.class);

    public PaymentServiceFactory(List<PaymentService> paymentServiceList) {
        for (PaymentService paymentService : paymentServiceList) {
            paymentMethodServiceCache.put(paymentService.getPaymentMethod(), paymentService);
        }
    }

    public PaymentService get(PaymentMethod paymentMethod) {
        return paymentMethodServiceCache.get(paymentMethod);
    }
}
