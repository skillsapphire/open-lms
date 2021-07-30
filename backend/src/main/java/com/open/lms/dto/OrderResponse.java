package com.open.lms.dto;

import com.open.lms.model.OrderStatus;
import com.open.lms.model.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String message;
    private String orderId;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
}
