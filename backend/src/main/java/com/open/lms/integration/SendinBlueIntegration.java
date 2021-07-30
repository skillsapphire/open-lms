package com.open.lms.integration;

import com.open.lms.model.LmsUser;
import com.open.lms.model.MailProvider;
import com.open.lms.model.School;
import org.springframework.stereotype.Service;

@Service
public class SendinBlueIntegration implements MailIntegration {
    @Override
    public void registerUser(LmsUser lmsUser, School school) {

    }

    @Override
    public MailProvider getProviderType() {
        return MailProvider.SENDIN_BLUE;
    }
}
