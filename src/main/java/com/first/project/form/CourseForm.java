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

    public List<CourseForm> convertDomainToDto(List<Course> course) {
        List<CourseForm> listaType = new ArrayList<>();
        course.forEach(cursoDomain -> listaType.add(convertDomainToType(cursoDomain)));
        return listaType;
    }

    public static CourseForm convertDomainToType(Course courseDomain) {
        CourseForm cursoType = new CourseForm();
        cursoType.setId(courseDomain.getId());
        cursoType.setName(courseDomain.getName());

        return cursoType;
    }

    public Course convertTypeToDomain(CourseForm cursoType) {
        Course courseDomain = new Course();
        courseDomain.setId(cursoType.getId());
        courseDomain.setName(cursoType.getName());

        return courseDomain;
    }

}
