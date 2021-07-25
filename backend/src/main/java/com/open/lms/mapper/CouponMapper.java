package com.open.lms.mapper;

import com.open.lms.dto.CouponDTO;
import com.open.lms.model.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponMapper {

    public CouponDTO mapToDTO(final Coupon coupon, final CouponDTO couponDTO) {
        couponDTO.setId(coupon.getId());
        couponDTO.setName(coupon.getName());
        couponDTO.setDiscount(coupon.getDiscount());
        couponDTO.setCode(coupon.getCode());
        couponDTO.setExpiration(coupon.getExpiration());
        return couponDTO;
    }

    public Coupon mapToEntity(final CouponDTO couponDTO, final Coupon coupon) {
        coupon.setId(couponDTO.getId());
        coupon.setName(couponDTO.getName());
        coupon.setDiscount(couponDTO.getDiscount());
        coupon.setCode(couponDTO.getCode());
        coupon.setExpiration(couponDTO.getExpiration());
        return coupon;
    }
}
