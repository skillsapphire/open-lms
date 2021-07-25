package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "Course")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    private String id;
    private String name;
    private String slug;
    private LmsUser instructor;
    private String description;
    private String imageUrl;
    private Money price;
    private List<Module> modules;
    private List<LmsUser> adminUsers;
    private List<LmsUser> enrollments;
    private String seoTitle;
    private String seoDescription;
    private List<String> seoKeywords;
    private PricingType pricingType;
    private Money discountedPrice;
    private CourseStatus status;
    private String schoolId;
    private Coupon currentActiveCoupon;
}
