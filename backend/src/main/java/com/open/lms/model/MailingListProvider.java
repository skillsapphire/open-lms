package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailingListProvider {
    private MailProvider mailProvider;
    private String apiKey;
    private String listIdentifier;
}
