package com.open.lms.mapper;

import com.open.lms.dto.course.CourseDetailViewDTO;
import com.open.lms.model.Course;
import com.open.lms.model.LmsUser;
import com.open.lms.model.Module;
import com.open.lms.repository.LmsUserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ModuleMapper.class, LmsUserRepository.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@RequiredArgsConstructor
public abstract class CourseMapper {

    private ModuleMapper moduleMapper;
    private LmsUserRepository lmsUserRepository;

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

    @Mapping(target = "curriculumViewDTO", ignore = true)
    @Mapping(target = "courseStatus", ignore = true)
    @Mapping(target = "courseSettingsViewDTO", ignore = true)
    @Mapping(target = "coursePricingView", ignore = true)
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.name", source = "name")
    @Mapping(target = "courseSettingsViewDTO.basicSettingsView.slug", source = "slug")
    public abstract CourseDetailViewDTO mapToDetailViewDto(Course course);

    List<LmsUser> mapAdminUsers(List<String> adminUserIds) {
        return lmsUserRepository.findByIdIn(adminUserIds);
    }

    List<Module> mapModuleEntityList(CourseDetailViewDTO courseDetailViewDTO) {
        return moduleMapper.mapToEntityList(courseDetailViewDTO.getCurriculumViewDTO().getModuleDTOList());
    }
}
