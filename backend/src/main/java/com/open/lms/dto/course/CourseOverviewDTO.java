package com.open.lms.dto.course;

import com.open.lms.model.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOverviewDTO {
    private String courseId;
    private String name;
    private String author;
    private CourseStatus courseStatus;
}
