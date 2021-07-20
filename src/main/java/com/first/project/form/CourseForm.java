package com.first.project.form;

import com.first.project.domain.Course;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseForm {

    private Long id;

    @NotBlank
    private String name;

    public List<CourseForm> convertDomainToDto(List<Course> course) {
        List<CourseForm> listaType = new ArrayList<>();
        course.forEach(cursoDomain -> listaType.add(convertDomainToType(cursoDomain)));
        return listaType;
    }

    public CourseForm convertDomainToType(Course courseDomain) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
