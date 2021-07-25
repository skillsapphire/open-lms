package com.open.lms.service;

import com.open.lms.dto.SchoolDTO;
import com.open.lms.mapper.SchoolMapper;
import com.open.lms.model.School;
import com.open.lms.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(school -> schoolMapper.mapToDTO(school, new SchoolDTO()))
                .collect(Collectors.toList());
    }

    public SchoolDTO get(final String id) {
        return schoolRepository.findById(id)
                .map(school -> schoolMapper.mapToDTO(school, new SchoolDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String create(final SchoolDTO schoolDTO) {
        var school = new School();
        schoolMapper.mapToEntity(schoolDTO, school);
        return schoolRepository.save(school).getId();
    }

    public void update(final String id, final SchoolDTO schoolDTO) {
        var school = schoolRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        schoolMapper.mapToEntity(schoolDTO, school);
        schoolRepository.save(school);
    }

    public void delete(final String id) {
        schoolRepository.deleteById(id);
    }

}
