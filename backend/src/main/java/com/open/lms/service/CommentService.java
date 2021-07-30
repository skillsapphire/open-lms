package com.open.lms.service;

import com.open.lms.dto.CommentDTO;
import com.open.lms.model.Comment;
import com.open.lms.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentDTO> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(comment -> mapToDTO(comment, new CommentDTO()))
                .collect(Collectors.toList());
    }

    public CommentDTO get(final String id) {
        return commentRepository.findById(id)
                .map(comment -> mapToDTO(comment, new CommentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String create(final CommentDTO commentDTO) {
        var comment = new Comment();
        return commentRepository.save(mapToEntity(commentDTO, comment)).getId();
    }

    public void update(final String id, final CommentDTO commentDTO) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        commentRepository.save(mapToEntity(commentDTO, comment));
    }

    public void delete(final String id) {
        commentRepository.deleteById(id);
    }

    private CommentDTO mapToDTO(final Comment comment, final CommentDTO commentDTO) {
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setParentCommentId(comment.getParentCommentId());
        commentDTO.setCourseId(comment.getCourseId());
        commentDTO.setCommentDate(comment.getCommentDate());
        return commentDTO;
    }

    private Comment mapToEntity(final CommentDTO commentDTO, final Comment comment) {
        comment.setText(commentDTO.getText());
        comment.setAuthor(commentDTO.getAuthor());
        comment.setParentCommentId(commentDTO.getParentCommentId());
        comment.setCourseId(commentDTO.getCourseId());
        comment.setCommentDate(commentDTO.getCommentDate());
        return comment;
    }

}
