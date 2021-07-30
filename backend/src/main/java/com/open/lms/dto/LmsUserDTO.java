package com.open.lms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class LmsUserDTO {

    @NotNull
    @Size(max = 255)
    private String id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private List<OrderDTO> orders;

    @NotNull
    private String schoolId;

}
