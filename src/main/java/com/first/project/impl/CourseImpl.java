package com.first.project.impl;

import com.first.project.domain.Course;
import com.first.project.form.CourseForm;
import com.first.project.repository.CourseRepository;
import com.first.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseForm courseForm;


    @Override
    public CourseForm saveCourse(CourseForm courseForm) {
        Course courseSave = courseRepository.save(courseForm.convertTypeToDomain(courseForm));
        return courseForm.convertDomainToType(courseSave);
    };

    @Override
    public List<CourseForm> findAll() {
        List<Course> listCourse = courseRepository.findAll();
        return courseForm.convertDomainToDto(listCourse);
    }
}
