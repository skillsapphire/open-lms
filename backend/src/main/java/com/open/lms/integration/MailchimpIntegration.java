package com.open.lms.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.lms.exceptions.ApplicationException;
import com.open.lms.model.LmsUser;
import com.open.lms.model.MailProvider;
import com.open.lms.model.School;
import com.open.lms.repository.LmsUserRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MailchimpIntegration implements MailIntegration {

    private final RestTemplate restTemplate;
    private final LmsUserRepository lmsUserRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Async
    @Retryable(value = ApplicationException.class, maxAttempts = 5, backoff = @Backoff(delay = 1000))
    public void registerUser(LmsUser lmsUser, School school) {
        String apiKey = school.getMailingListProvider().getApiKey();
        String server = apiKey.split("-")[1];
        var mailChimpUrl = String.format("https://%s.api.mailchimp.com/3.0/lists/%s/members?skip_merge_validation=true",
                server,
                school.getMailingListProvider().getListIdentifier());

        MailChimpRequest mailChimpRequest = MailChimpRequest.builder()
                .emailAddress(lmsUser.getEmail())
                .status("subscribed")
                .build();

        try {
            var objectStr = objectMapper.writeValueAsString(mailChimpRequest);
            var jsonObject = new JsonObject(objectStr);
            ResponseEntity<String> mailChimpResponse = restTemplate.postForEntity(mailChimpUrl, jsonObject, String.class);

            if (mailChimpResponse.getStatusCode().is5xxServerError()) {
                throw new ApplicationException("Error occurred while contacting Mailchimp to subscribe users");
            }

            if (mailChimpResponse.getStatusCode().is2xxSuccessful()) {
                lmsUser.setSubscribed(true);
                lmsUserRepository.save(lmsUser);
            }
        } catch (JsonProcessingException e) {
            throw new ApplicationException("Error occurred while registering users to Mailchimp", e);
        }
    }

    @Override
    public MailProvider getProviderType() {
        return MailProvider.MAILCHIMP;
    }
}

@Data
@Builder
class MailChimpRequest {
    @JsonProperty("email_address")
    private String emailAddress;
    private String status;
}
