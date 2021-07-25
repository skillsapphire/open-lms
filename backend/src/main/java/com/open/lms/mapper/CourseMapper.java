package com.open.lms.mapper;

import com.open.lms.dto.course.CourseDetailViewDTO;
import com.open.lms.model.Course;
import com.open.lms.model.LmsUser;
import com.open.lms.model.Module;
import com.open.lms.repository.LmsUserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class, LmsUserRepository.class})
public abstract class CourseMapper {

    @Autowired
    ModuleMapper moduleMapper;
    @Autowired
    LmsUserRepository lmsUserRepository;

    @Mapping(target = "id", ignore = true)// Filled When Entity is saved to DB
    // BasicSettingsView Mappings
    @Mapping(target = "name", source = "courseDetailViewDTO.courseSettingsViewDTO.basicSettingsView.name")
    @Mapping(target = "slug", source = "courseDetailViewDTO.courseSettingsViewDTO.basicSettingsView.slug")
    @Mapping(target = "description", source = "courseDetailViewDTO.courseSettingsViewDTO.basicSettingsView.description")
    @Mapping(target = "imageUrl", source = "courseDetailViewDTO.courseSettingsViewDTO.basicSettingsView.imageUrl")
    @Mapping(target = "adminUsers", expression = "java(mapAdminUsers(courseDetailViewDTO.getCourseSettingsViewDTO().getCourseStaffSettingsView().getAdminUserIds()))")
    // Course Pricing View Mappings
    @Mapping(target = "price", source = "courseDetailViewDTO.coursePricingView.price")
    @Mapping(target = "pricingType", source = "courseDetailViewDTO.coursePricingView.pricingType")
    // SEO Settings View
    @Mapping(target = "seoTitle", source = "courseDetailViewDTO.courseSettingsViewDTO.seoSettingsView.seoTitle")
    @Mapping(target = "seoDescription", source = "courseDetailViewDTO.courseSettingsViewDTO.seoSettingsView.seoDescription")
    @Mapping(target = "seoKeywords", source = "courseDetailViewDTO.courseSettingsViewDTO.seoSettingsView.seoKeywords")
    // Course Status
    @Mapping(target = "status", source = "courseDetailViewDTO.courseStatus")
    @Mapping(target = "modules", expression = "java(mapModuleEntityList(courseDetailViewDTO))")
    public abstract Course mapToEntity(CourseDetailViewDTO courseDetailViewDTO, Course course);

    // Curriculum View DTO
    @Mapping(target = "curriculumViewDTO.moduleDTOList", expression = "java(moduleMapper.mapToDTOList(course.getModules()))")
    // Course Status View DTO
    @Mapping(target = "courseStatus", source = "status")
    // Course Pricing View DTO
    @Mapping(target = "coursePricingView.price", source = "price")
    @Mapping(target = "coursePricingView.pricingType", source = "pricingType")
    // Course Basic Settings View DTO
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.name", source = "name")
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.slug", source = "slug")
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.description", source = "description")
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.imageUrl", source = "imageUrl")
    // Course Staff Settings View DTO
    @Mapping(target = "courseSettingsViewDTO.courseStaffSettingsView.adminUserIds",
            expression = "java(course.getAdminUsers().stream().map(LmsUser::getId).collect(java.util.stream.Collectors.toList()))")
    @Mapping(target = "courseSettingsViewDTO.seoSettingsView.seoTitle", source = "seoTitle")
    @Mapping(target = "courseSettingsViewDTO.seoSettingsView.seoDescription", source = "seoDescription")
    @Mapping(target = "courseSettingsViewDTO.seoSettingsView.seoKeywords", source = "seoKeywords")
    public abstract CourseDetailViewDTO mapToDetailViewDto(Course course);

    List<LmsUser> mapAdminUsers(List<String> adminUserIds) {
//        return lmsUserRepository.findByIdIn(adminUserIds);
        return Collections.emptyList();
    }

    List<Module> mapModuleEntityList(CourseDetailViewDTO courseDetailViewDTO) {
        return moduleMapper.mapToEntityList(courseDetailViewDTO.getCurriculumViewDTO().getModuleDTOList());
    }
}
