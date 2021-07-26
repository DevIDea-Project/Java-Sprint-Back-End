package com.first.project.form;

import com.first.project.domain.Course;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class CourseForm {

    private Long id;

    @NotBlank
    private String name;

    public static List<CourseForm> convertDomainToDto(List<Course> course) {
        List<CourseForm> listType = new ArrayList<>();
        course.forEach(courseDomain -> listType.add(convertDomainToType(courseDomain)));
        return listType;
    }

    public static CourseForm convertDomainToType(Course courseDomain) {
        CourseForm courseType = new CourseForm();
        courseType.setId(courseDomain.getId());
        courseType.setName(courseDomain.getName());

        return courseType;
    }

    public static Course convertTypeToDomain(CourseForm course) {
        Course courseDomain = new Course();
        courseDomain.setId(course.getId());
        courseDomain.setName(course.getName());

        return courseDomain;
    }

}
