package com.open.lms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.Instant;


@Getter
@Setter
public class CommentDTO {

    private String id;

    @Size(max = 255)
    private String text;

    @Size(max = 255)
    private String author;

    @Size(max = 255)
    private String parentCommentId;

    @Size(max = 255)
    private String courseId;

    private Instant commentDate;

}
