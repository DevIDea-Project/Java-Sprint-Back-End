package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.form.StudentForm;
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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@Order(1)
class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    @Autowired
    private CourseController courseController;

    @BeforeEach
    void configuraMock() {
        openMocks(this);
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
    void returnCourseForId() {
        Integer id = 1;
        ResponseEntity<CourseForm> response = courseController.listCourseId(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    void returnUpdateCourse() {
        Integer id = 1;
        CourseForm newCourse = createCourseForm("JavaScript");
        ResponseEntity<CourseForm> response = courseController.updateCourse(id.longValue(), newCourse);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(5)
    void createStudent() {
        ResponseEntity<StudentForm> response = studentController.createStudent(createStudentForm());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @Order(6)
    void returnAllStudent() {
        ResponseEntity<List<StudentForm>> response = studentController.listStudent();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(7)
    void returnStudentForId() {
        Integer id = 1;
        ResponseEntity<StudentForm> response = studentController.listStudentId(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(8)
    void returnStudentForIdNull() {
        Integer id = 8;
        ResponseEntity<StudentForm> response = studentController.listStudentId(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(9)
    void returnUpdateStudent() {
        Integer id = 1;
        StudentForm newStudent = createStudentForm();
        ResponseEntity<StudentForm> response = studentController.updateStudent(id.longValue(), newStudent);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(10)
    void returnUpdateStudentNull() {
        Integer id = 7;
        StudentForm newStudent = createStudentForm();
        ResponseEntity<StudentForm> response = studentController.updateStudent(id.longValue(), newStudent);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(11)
    void deleteStudent() {
        Integer id = 1;
        ResponseEntity<StudentForm> response = studentController.deleteStudent(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(12)
    void deleteStudentNull() {
        Integer id = 9;
        ResponseEntity<StudentForm> response = studentController.deleteStudent(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(13)
    void deleteCourse() {
        Integer id = 1;
        ResponseEntity<CourseForm> response = courseController.deleteCourse(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    private StudentForm createStudentForm() {
        StudentForm newStudent = new StudentForm();
        newStudent.setName("Curso 01");
        newStudent.setAddress("Rua Poloni 268");
        newStudent.setPhoneNumber("7897987987989");

        CourseForm course = new CourseForm();
        Integer id = 1;
        course.setId(id.longValue());
        newStudent.setCourse(course);

        return newStudent;
    }

    private CourseForm createCourseForm(String name) {
        CourseForm newCourse = new CourseForm();
        newCourse.setName(name);
        return newCourse;
    }
}