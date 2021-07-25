package com.open.lms.controller;

import com.open.lms.dto.LmsUserDTO;
import com.open.lms.service.LmsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/lmsUsers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LmsUserController {

    private final LmsUserService lmsUserService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LmsUserDTO> getAllLmsUsers() {
        return lmsUserService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LmsUserDTO getLmsUser(@PathVariable final String id) {
        return lmsUserService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLmsUser(@RequestBody @Valid final LmsUserDTO lmsUserDTO) {
        lmsUserService.create(lmsUserDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLmsUser(@PathVariable final String id,
                              @RequestBody @Valid final LmsUserDTO lmsUserDTO) {
        lmsUserService.update(id, lmsUserDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLmsUser(@PathVariable final String id) {
        lmsUserService.delete(id);
    }

}
