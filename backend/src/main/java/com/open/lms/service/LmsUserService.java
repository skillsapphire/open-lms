package com.open.lms.service;

import com.open.lms.dto.LmsUserDTO;
import com.open.lms.mapper.LmsUserMapper;
import com.open.lms.model.LmsUser;
import com.open.lms.repository.LmsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class LmsUserService {

    private final LmsUserMapper lmsUserMapper;
    private final LmsUserRepository lmsUserRepository;

    public List<LmsUserDTO> findAll() {
        return lmsUserRepository.findAll()
                .stream()
                .map(lmsUserMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public LmsUserDTO get(final String id) {
        return lmsUserRepository.findById(id)
                .map(lmsUserMapper::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String create(final LmsUserDTO lmsUserDTO) {
        var lmsUser = new LmsUser();
        lmsUserMapper.mapToEntity(lmsUserDTO, lmsUser);
        return lmsUserRepository.save(lmsUser).getId();
    }

    public void update(final String id, final LmsUserDTO lmsUserDTO) {
        var lmsUser = lmsUserRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        lmsUserMapper.mapToEntity(lmsUserDTO, lmsUser);
        lmsUserRepository.save(lmsUser);
    }

    public void delete(final String id) {
        lmsUserRepository.deleteById(id);
    }

    public LmsUserDTO validateUser(String authorization) {
        return null;
    }
}
