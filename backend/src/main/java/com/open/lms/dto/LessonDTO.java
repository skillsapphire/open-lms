package com.open.lms.dto;

import com.open.lms.model.LessonType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class LessonDTO {

    @NotNull
    @Size(max = 255)
    private String id;

    @Size(max = 255)
    private String title;

    private LessonType lessonType;

    @Size(max = 255)
    private String mediaUrl;

    @Size(max = 255)
    private String text;

    private Boolean downloadable;

    @Size(max = 255)
    private Boolean needEnrollment;

    @Size(max = 255)
    private String courseId;

    @Size(max = 255)
    private String instructorId;

    private Boolean enableComments;

    private Boolean enableFreePreview;

    private Boolean draft;

    private String moduleId;

    private List<CommentDTO> commentDTOS;
}
