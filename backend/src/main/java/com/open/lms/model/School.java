package com.open.lms.model;

import com.open.lms.service.payment.PaymentConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "School")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {

    @Id
    private String id;
    private String name;
    private String domainName;
    private CurrencyUnit currencyUnit;
    private String logoUrl;
    private String schoolAddress;
    private PaymentConfig paymentConfig;
    private Boolean enableGoogleLogin;
    private Boolean enableFacebookLogin;
    private Boolean enableGithubLogin;
    private String orderIDPrefix;
    private int orderIdStartingValue;
    private MailingListProvider mailingListProvider;
    private List<Course> courses;
}
