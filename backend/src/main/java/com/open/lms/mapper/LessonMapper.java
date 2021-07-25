package com.open.lms.mapper;

import com.open.lms.dto.LessonDTO;
import com.open.lms.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
@Service
public abstract class LessonMapper {

    @Autowired
    CommentMapper commentMapper;

    @Mapping(target = "comments", expression = "java(commentMapper.mapToEntityList(lessonDTO.getCommentDTOS()))")
    abstract Lesson mapToEntity(final LessonDTO lessonDTO);

    abstract List<LessonDTO> mapToDTOList(List<Lesson> lessons);

    abstract List<Lesson> mapToEntityList(List<LessonDTO> lessonDTOS);

    @Mapping(target = "commentDTOS", expression = "java(commentMapper.mapToDTOList(lesson.getComments()))")
    abstract LessonDTO mapToDTO(final Lesson lesson);
}
