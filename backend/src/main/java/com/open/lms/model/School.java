package com.open.lms.model;

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
    private String stripeKey;
    private String paypalKey;
    private String paytmKey;
    private PaymentMethod paymentMethod;
    private Boolean enableGoogleLogin;
    private Boolean enableFacebookLogin;
    private Boolean enableGithubLogin;
    private String orderIDPrefix;
    private int orderIdStartingValue;
    private String mailChimpIntegrationKey;
    private String activeCampaignIntegrationKey;
    private String sendinBlueIntegrationKey;
    private String convertKitIntegrationKey;
    private List<Course> courses;
}
