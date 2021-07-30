package com.open.lms.service;

import com.open.lms.dto.course.CourseDetailViewDTO;
import com.open.lms.dto.course.InitCourseDTO;
import com.open.lms.mapper.CourseMapper;
import com.open.lms.model.Course;
import com.open.lms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;


    public List<CourseDetailViewDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::mapToDetailViewDto)
                .collect(Collectors.toList());
    }

    public CourseDetailViewDTO get(final String id) {
        return courseRepository.findById(id)
                .map(courseMapper::mapToDetailViewDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void update(final String id, CourseDetailViewDTO courseDetailViewDTO) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var updatedCourse = courseMapper.mapToEntity(courseDetailViewDTO, course);
        updatedCourse.setId(course.getId());
        courseRepository.save(updatedCourse);
    }

    public void delete(final String id) {
        courseRepository.deleteById(id);
    }


    public CourseDetailViewDTO initCourse(InitCourseDTO initCourseDTO) {
        var course = new Course();
        course.setName(initCourseDTO.getCourseName());
        course.setSlug(initCourseDTO.getCourseName());
        course.setSchoolId(initCourseDTO.getSchoolId());
        course.setInstructor(null);
        course.setModules(Collections.emptyList());
        course.setAdminUsers(Collections.emptyList());
        courseRepository.save(course);
        return courseMapper.mapToDetailViewDto(course);
    }
}
