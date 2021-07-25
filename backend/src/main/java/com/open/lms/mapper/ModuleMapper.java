package com.open.lms.mapper;

import com.open.lms.dto.course.CourseDetailViewDTO;
import com.open.lms.model.Module;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ModuleMapper {

    LessonMapper lessonMapper;

    public abstract List<CourseDetailViewDTO.ModuleDTO> mapToDTOList(List<Module> modules);

    @Mapping(target = "lessonDTOS", expression = "java(lessonMapper.mapToDTOList(module.getLessons()))")
    public abstract CourseDetailViewDTO.ModuleDTO mapToDTO(Module module);

    public abstract List<Module> mapToEntityList(List<CourseDetailViewDTO.ModuleDTO> moduleDTOList);

    @Mapping(target = "lessons", expression = "java(lessonMapper.mapToEntityList(moduleDTO.getLessonDTOS()))")
    public abstract Module mapToEntity(CourseDetailViewDTO.ModuleDTO moduleDTO);

}
