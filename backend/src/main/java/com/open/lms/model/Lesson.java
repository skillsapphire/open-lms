package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    private String id;
    private String title;
    private LessonType lessonType;
    private String mediaUrl;
    private String text;
    private boolean downloadable;
    private boolean needEnrollment;
    private String courseId;
    private String instructorId;
    private boolean enableComments;
    private boolean enableFreePreview;
    private boolean draft;
    private List<Comment> comments;
    private String moduleId;
}
