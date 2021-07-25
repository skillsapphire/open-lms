package com.open.lms.dto;

import com.open.lms.model.CurrencyUnit;
import com.open.lms.model.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
public class SchoolDTO {

    @Size(max = 255)
    private String id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String domainName;

    private CurrencyUnit currencyUnit;

    @Size(max = 255)
    private String schoolAddress;

    @Size(max = 255)
    private String stripeKey;

    @Size(max = 255)
    private String paypalKey;

    @Size(max = 255)
    private String paytmKey;

    private PaymentMethod paymentMethod;

    private Boolean enableGoogleLogin;

    private Boolean enableFacebookLogin;

    private Boolean enableGithubLogin;

    @Size(max = 5)
    private String orderIdPrefix;

    private Integer orderIdStartingValue;

    @Size(max = 255)
    private String mailChimpIntegrationKey;

    @Size(max = 255)
    private String activeCampaignIntegrationKey;

    @Size(max = 255)
    private String sendinBlueIntegrationKey;

    @Size(max = 255)
    private String convertKitIntegrationKey;

}
