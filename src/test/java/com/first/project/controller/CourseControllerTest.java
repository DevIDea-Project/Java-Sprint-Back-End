package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
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

//    @Test
    @org.junit.jupiter.api.Test
    public void contextLoads() {
        Assertions.assertTrue(true);
    }

//    @Test
    @org.junit.jupiter.api.Test
    public void list() {
        ResponseEntity<List<CourseForm>> listCourse = courseController.list();
        List<CourseForm> body = listCourse.getBody();
        boolean result = body != null && !body.isEmpty() ? true : false;
        assertTrue(result);
    }

}