package com.open.lms.dto;

import com.open.lms.model.Discount;
import com.open.lms.model.OrderStatus;
import com.open.lms.model.PaymentMethod;
import com.open.lms.model.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.javamoney.moneta.Money;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;


@Getter
@Setter
public class OrderDTO {
    private String id;

    @NotNull
    private String courseId;
    private String schoolId;
    private Instant orderedDate;

    @NotNull
    private String paymentId;

    private Money finalPrice;
    private Money originalPrice;

    @Valid
    private Discount discount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;

}
