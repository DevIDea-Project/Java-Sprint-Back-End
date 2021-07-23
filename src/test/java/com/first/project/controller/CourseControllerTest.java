package com.first.project.controller;

import com.first.project.form.CourseForm;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class CourseControllerTest {

    @Autowired
    private CourseController courseController;

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
    public void createCourse() {
        ResponseEntity<CourseForm> response = courseController.create(createCourseForm("javaScript"));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }

    @org.junit.jupiter.api.Test
    void returnAllCourse() {
        ResponseEntity<List<CourseForm>> response = courseController.list();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

//    @org.junit.jupiter.api.Test
//    void returnCoursePeloId() {
//        Integer id = 1;
//        ResponseEntity<CourseForm> response = courseController.listId(id.longValue());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }



//    @org.junit.jupiter.api.Test
//    void returnUpdateCourse() {
//
//        Integer id = 2;
//        ResponseEntity<CourseForm> response = courseController.updateVeiculo(id.longValue(), createCourseForm("javaScript"));
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//    }

//    @org.junit.jupiter.api.Test
//    void deleteCourse() {
//        Integer id = 1;
//        ResponseEntity<CourseForm> response = courseController.deleteCourse(id.longValue());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}