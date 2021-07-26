package com.first.project.service;

import com.first.project.form.CourseForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    public CourseForm saveCourse(CourseForm CourseForm);

    public List<CourseForm> findAll();

    public CourseForm findByIdCourse(Long id);

    public CourseForm updateCourse(Long id, CourseForm courseForm);

    public CourseForm deleteCourse(Long id);

}
