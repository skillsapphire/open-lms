package com.open.lms.mapper;

import com.open.lms.dto.CommentDTO;
import com.open.lms.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment mapToEntity(final CommentDTO commentDTO);

    List<CommentDTO> mapToDTOList(List<Comment> lessons);

    List<Comment> mapToEntityList(List<CommentDTO> lessonDTOS);

    CommentDTO mapToDTO(final Comment lesson);
}
