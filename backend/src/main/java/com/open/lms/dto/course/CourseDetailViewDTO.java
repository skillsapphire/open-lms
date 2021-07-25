package com.open.lms.dto.course;

import com.open.lms.dto.LessonDTO;
import com.open.lms.model.CourseStatus;
import com.open.lms.model.PricingType;
import lombok.Data;
import org.javamoney.moneta.Money;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CourseDetailViewDTO {

    private String id;
    @Valid
    private CurriculumViewDTO curriculumViewDTO;
    @Valid
    private CourseSettingsViewDTO courseSettingsViewDTO;
    @Valid
    private CourseDetailViewDTO.CoursePricingView coursePricingView;
    @NotNull
    private CourseStatus courseStatus;

    @Data
    public static class CurriculumViewDTO {
        @Valid
        private List<ModuleDTO> moduleDTOList;
    }

    @Data
    public static class ModuleDTO {
        private String id;
        @NotNull
        private String title;
        private List<LessonDTO> lessonDTOS;
        private Boolean draft;
    }

    @Data
    public static class CourseSettingsViewDTO {
        @Valid
        private BasicSettingsView basicSettingsView;
        private CourseStaffSettingsView courseStaffSettingsView;
        private SeoSettingsView seoSettingsView;

        @Data
        public static class BasicSettingsView {
            @NotNull
            private String name;
            @NotNull
            private String slug;
            private String userId;
            private String imageUrl;
            private String description;
        }

        @Data
        public static class CourseStaffSettingsView {
            private List<String> adminUserIds;
        }

        @Data
        public static class SeoSettingsView {
            private String seoTitle;
            private String seoDescription;
            private List<String> seoKeywords;
        }
    }

    @Data
    public static class CoursePricingView {
        private Money price;
        @NotNull
        private PricingType pricingType;
    }
}
