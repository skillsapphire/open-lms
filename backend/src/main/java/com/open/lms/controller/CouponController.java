package com.open.lms.controller;

import com.open.lms.dto.CouponDTO;
import com.open.lms.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/coupons", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CouponDTO> getAllCoupons() {
        return couponService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CouponDTO getCoupon(@PathVariable final String id) {
        return couponService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCoupon(@RequestBody @Valid final CouponDTO couponDTO) {
        couponService.create(couponDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCoupon(@PathVariable final String id,
                             @RequestBody @Valid final CouponDTO couponDTO) {
        couponService.update(id, couponDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCoupon(@PathVariable final String id) {
        couponService.delete(id);
    }
}
