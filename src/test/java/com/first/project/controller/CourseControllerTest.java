package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

public class CourseControllerTest {

    @Autowired
    private CourseController courseController;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    BindingResult bindingResult;

    @BeforeEach
    public void configuraMock() {
        openMocks(this);
    }

    private CourseForm createCourseForm(String name) {
        CourseForm newCourse = new CourseForm();
        newCourse.setName(name);
        return newCourse;
    }


    @org.junit.jupiter.api.Test
    public void contextLoads() {
        Assertions.assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    void list() {
        ResponseEntity<List<CourseForm>> listCourse = courseController.list();
        boolean result = listCourse.getBody() != null && !listCourse.getBody().isEmpty() ? true : false;
        assertTrue(result);
    }

}