package com.open.lms.dto;

import com.open.lms.model.Discount;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;


@Getter
@Setter
public class CouponDTO {

    @NotNull
    @Size(max = 255)
    private String id;

    @Size(max = 255)
    private String name;

    @Valid
    private Discount discount;

    @Size(max = 255)
    private String code;

    private Instant expiration;

}
