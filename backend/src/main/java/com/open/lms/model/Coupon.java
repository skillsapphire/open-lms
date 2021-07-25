package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(value = "Coupon")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {
    @Id
    private String id;
    private String name;
    private String code;
    private Discount discount;
    private Instant expiration;
    private List<Course> appliedCourses;
}
