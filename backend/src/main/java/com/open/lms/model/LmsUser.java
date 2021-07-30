package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "LmsUser")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LmsUser {
    @Id
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private List<Order> orders;
    private String email;
    private Boolean subscribed;
}
