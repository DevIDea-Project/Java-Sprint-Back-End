package com.first.project.controller;

import com.first.project.form.CourseForm;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseControllersTest {

    @Autowired
    private CourseController courseController;

    @BeforeEach
    void configuraMock() {
        openMocks(this);
    }

    private CourseForm createCourseForm(String name) {
        CourseForm newCourse = new CourseForm();
        newCourse.setName(name);
        return newCourse;
    }

    @Test
    @Order(1)
    void contextLoads() {
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void createCourse() {
        ResponseEntity<CourseForm> response = courseController.create(createCourseForm("DDO"));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @Order(3)
    void returnAllCourse() {
        ResponseEntity<List<CourseForm>> response = courseController.list();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    void returnCourseForId() {
        Integer id = 1;
        ResponseEntity<CourseForm> response = courseController.listCourseId(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(5)
    void returnCourseForIdNull() {
        Integer id = 8;
        ResponseEntity<CourseForm> response = courseController.listCourseId(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(6)
    void returnUpdateCourse() {
        Integer id = 1;
        CourseForm newCourse = createCourseForm("JavaScript");
        ResponseEntity<CourseForm> response = courseController.updateCourse(id.longValue(), newCourse);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(7)
    void returnUpdateCourseNull() {
        Integer id = 7;
        CourseForm newCourse = createCourseForm("JavaScript");
        ResponseEntity<CourseForm> response = courseController.updateCourse(id.longValue(), newCourse);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(8)
    void deleteCourse() {
        Integer id = 1;
        ResponseEntity<CourseForm> response = courseController.deleteCourse(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(9)
    void deleteCourseNull() {
        Integer id = 9;
        ResponseEntity<CourseForm> response = courseController.deleteCourse(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}