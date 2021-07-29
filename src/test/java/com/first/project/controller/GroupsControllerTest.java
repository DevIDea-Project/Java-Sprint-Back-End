package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.form.GroupsForm;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
class GroupsControllerTest {

    @Autowired
    private GroupsController groupsController;

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

    private GroupsForm createGroupForm() {
        GroupsForm group = new GroupsForm();

        group.setName("curso 02");
        group.setNameTeacher("Vitor Gabriel");

        CourseForm course = new CourseForm();
        Integer id = 2;
        course.setId(id.longValue());
        group.setCourse(course);

        return group;
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

//    @Test
//    @Order(3)
//    void createGroups() {
//        ResponseEntity<GroupsForm> response = groupsController.createGroups(createGroupForm());
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    }

    @Test
    @Order(4)
    void returnAllCourse() {
        ResponseEntity<List<GroupsForm>> response = groupsController.listGroupes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}