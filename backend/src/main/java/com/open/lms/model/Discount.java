package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discount {
    private DiscountType discountType;
    private Money discountAmount;
    private String discountPercentage;
}
