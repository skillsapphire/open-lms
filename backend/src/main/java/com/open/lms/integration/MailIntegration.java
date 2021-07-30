package com.open.lms.integration;

import com.open.lms.model.LmsUser;
import com.open.lms.model.MailProvider;
import com.open.lms.model.School;

public interface MailIntegration {
    void registerUser(LmsUser lmsUser, School school);

    MailProvider getProviderType();
}
