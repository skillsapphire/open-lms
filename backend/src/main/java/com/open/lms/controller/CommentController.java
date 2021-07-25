package com.open.lms.controller;

import com.open.lms.dto.CommentDTO;
import com.open.lms.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/comments", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO getComment(@PathVariable final String id) {
        return commentService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@RequestBody @Valid final CommentDTO commentDTO) {
        return commentService.create(commentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable final String id,
                              @RequestBody @Valid final CommentDTO commentDTO) {
        commentService.update(id, commentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable final String id) {
        commentService.delete(id);
    }

}
