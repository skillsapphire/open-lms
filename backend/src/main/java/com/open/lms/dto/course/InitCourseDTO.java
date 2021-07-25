package com.open.lms.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitCourseDTO {
    @NotBlank
    private String courseName;
    @NotBlank
    private String schoolId;
}
