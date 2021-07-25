package com.open.lms.controller;

import com.open.lms.dto.course.CourseDetailViewDTO;
import com.open.lms.dto.course.InitCourseDTO;
import com.open.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/courses", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDetailViewDTO> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDetailViewDTO getCourse(@PathVariable final String id) {
        return courseService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDetailViewDTO initCourse(@RequestBody @Valid InitCourseDTO initCourseDTO) {
        return courseService.initCourse(initCourseDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable final String id,
                             @RequestBody @Valid final CourseDetailViewDTO courseDetailViewDTO) {
        courseService.update(id, courseDetailViewDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable final String id) {
        courseService.delete(id);
    }

}
