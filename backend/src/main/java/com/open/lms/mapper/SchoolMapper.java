package com.open.lms.mapper;

import com.open.lms.dto.SchoolDTO;
import com.open.lms.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolDTO mapToDTO(final School school, final SchoolDTO schoolDTO) {
        schoolDTO.setId(school.getId());
        schoolDTO.setName(school.getName());
        schoolDTO.setDomainName(school.getDomainName());
        schoolDTO.setCurrencyUnit(school.getCurrencyUnit());
        schoolDTO.setSchoolAddress(school.getSchoolAddress());
        schoolDTO.setStripeKey(school.getStripeKey());
        schoolDTO.setPaypalKey(school.getPaypalKey());
        schoolDTO.setPaytmKey(school.getPaytmKey());
        schoolDTO.setPaymentMethod(school.getPaymentMethod());
        schoolDTO.setEnableGoogleLogin(school.getEnableGoogleLogin());
        schoolDTO.setEnableFacebookLogin(school.getEnableFacebookLogin());
        schoolDTO.setEnableGithubLogin(school.getEnableGithubLogin());
        schoolDTO.setOrderIdPrefix(school.getOrderIDPrefix());
        schoolDTO.setOrderIdStartingValue(school.getOrderIdStartingValue());
        schoolDTO.setMailChimpIntegrationKey(school.getMailChimpIntegrationKey());
        schoolDTO.setActiveCampaignIntegrationKey(school.getActiveCampaignIntegrationKey());
        schoolDTO.setSendinBlueIntegrationKey(school.getSendinBlueIntegrationKey());
        schoolDTO.setConvertKitIntegrationKey(school.getConvertKitIntegrationKey());
        return schoolDTO;
    }

    public School mapToEntity(final SchoolDTO schoolDTO, final School school) {
        school.setId(schoolDTO.getId());
        school.setName(schoolDTO.getName());
        school.setDomainName(schoolDTO.getDomainName());
        school.setCurrencyUnit(schoolDTO.getCurrencyUnit());
        school.setSchoolAddress(schoolDTO.getSchoolAddress());
        school.setStripeKey(schoolDTO.getStripeKey());
        school.setPaypalKey(schoolDTO.getPaypalKey());
        school.setPaytmKey(schoolDTO.getPaytmKey());
        school.setPaymentMethod(schoolDTO.getPaymentMethod());
        school.setEnableGoogleLogin(schoolDTO.getEnableGoogleLogin());
        school.setEnableFacebookLogin(schoolDTO.getEnableFacebookLogin());
        school.setEnableGithubLogin(schoolDTO.getEnableGithubLogin());
        school.setOrderIDPrefix(schoolDTO.getOrderIdPrefix());
        school.setOrderIdStartingValue(schoolDTO.getOrderIdStartingValue());
        school.setMailChimpIntegrationKey(schoolDTO.getMailChimpIntegrationKey());
        school.setActiveCampaignIntegrationKey(schoolDTO.getActiveCampaignIntegrationKey());
        school.setSendinBlueIntegrationKey(schoolDTO.getSendinBlueIntegrationKey());
        school.setConvertKitIntegrationKey(schoolDTO.getConvertKitIntegrationKey());
        return school;
    }
}
