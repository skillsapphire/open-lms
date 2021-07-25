package com.open.lms.mapper;

import com.open.lms.dto.LmsUserDTO;
import com.open.lms.model.LmsUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LmsUserMapper {

    public LmsUserDTO mapToDTO(final LmsUser lmsUser) {
        var lmsUserDTO = new LmsUserDTO();
        lmsUserDTO.setId(lmsUser.getId());
        lmsUserDTO.setName(lmsUser.getName());
        lmsUserDTO.setFirstName(lmsUser.getFirstName());
        lmsUserDTO.setLastName(lmsUser.getLastName());
        lmsUserDTO.setEmail(lmsUser.getEmail());
        // TODO: Map OrdersDto
        lmsUserDTO.setOrders(null);
        return lmsUserDTO;
    }

    public LmsUser mapToEntity(final LmsUserDTO lmsUserDTO, final LmsUser lmsUser) {
        lmsUser.setId(lmsUserDTO.getId());
        lmsUser.setName(lmsUserDTO.getName());
        lmsUser.setFirstName(lmsUserDTO.getFirstName());
        lmsUser.setLastName(lmsUserDTO.getLastName());
        lmsUser.setEmail(lmsUserDTO.getEmail());
        // TODO: Map Orders
        return lmsUser;
    }

    public List<LmsUserDTO> mapToDTOList(List<LmsUser> adminUsers) {
        return adminUsers.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
