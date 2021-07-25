package com.open.lms.controller;

import com.open.lms.dto.SchoolDTO;
import com.open.lms.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/schools", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolDTO> getAllSchools() {
        return schoolService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDTO getSchool(@PathVariable final String id) {
        return schoolService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchool(@RequestBody @Valid final SchoolDTO schoolDTO) {
        schoolService.create(schoolDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSchool(@PathVariable final String id,
                             @RequestBody @Valid final SchoolDTO schoolDTO) {
        schoolService.update(id, schoolDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchool(@PathVariable final String id) {
        schoolService.delete(id);
    }

}
