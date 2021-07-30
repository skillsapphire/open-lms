package com.open.lms.integration;

import com.open.lms.model.MailProvider;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
public class MailIntegrationFactory {

    private final Map<MailProvider, MailIntegration> mailProviderMap = new EnumMap<>(MailProvider.class);

    public MailIntegration get(MailProvider mailProvider) {
        return mailProviderMap.get(mailProvider);
    }

}
