package com.open.lms.service;

import com.open.lms.dto.CouponDTO;
import com.open.lms.mapper.CouponMapper;
import com.open.lms.model.Coupon;
import com.open.lms.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponMapper couponMapper;
    private final CouponRepository couponRepository;

    public List<CouponDTO> findAll() {
        return couponRepository.findAll()
                .stream()
                .map(coupon -> couponMapper.mapToDTO(coupon, new CouponDTO()))
                .collect(Collectors.toList());
    }

    public CouponDTO get(final String id) {
        return couponRepository.findById(id)
                .map(coupon -> couponMapper.mapToDTO(coupon, new CouponDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String create(final CouponDTO couponDTO) {
        var coupon = new Coupon();
        couponMapper.mapToEntity(couponDTO, coupon);
        return couponRepository.save(coupon).getId();
    }

    public void update(final String id, final CouponDTO couponDTO) {
        var coupon = couponRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        couponMapper.mapToEntity(couponDTO, coupon);
        couponRepository.save(coupon);
    }

    public void delete(final String id) {
        couponRepository.deleteById(id);
    }

}
