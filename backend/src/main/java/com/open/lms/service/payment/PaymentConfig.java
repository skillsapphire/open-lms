package com.open.lms.service.payment;

import com.open.lms.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentConfig {
    private String clientId;
    private String clientSecret;
    private PaymentMethod paymentMethod;
}
