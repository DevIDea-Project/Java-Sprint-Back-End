package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.form.GroupsForm;
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
class GroupsControllerTest {

    @Autowired
    private GroupsController groupsController;

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
    @Order(3)
    void createGroups() {
        ResponseEntity<GroupsForm> responses = groupsController.createGroups(createGroupForm());
        assertEquals(HttpStatus.CREATED, responses.getStatusCode());
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
    void returnAllGroups() {
        ResponseEntity<List<GroupsForm>> response = groupsController.listGroupes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(6)
    void returnGroupForId() {
        Integer id = 1;
        ResponseEntity<GroupsForm> response = groupsController.listGroupId(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(7)
    void returnGroupForIdNull() {
        Integer id = 8;
        ResponseEntity<GroupsForm> response = groupsController.listGroupId(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(8)
    void returnUpdateGroup() {
        Integer id = 1;
        GroupsForm newGroup = createGroupForm();
        ResponseEntity<GroupsForm> response = groupsController.updateGroup(id.longValue(), newGroup);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(9)
    void returnUpdateGroupNull() {
        Integer id = 7;
        GroupsForm newGroup = createGroupForm();
        ResponseEntity<GroupsForm> response = groupsController.updateGroup(id.longValue(), newGroup);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(10)
    void deleteGroup() {
        Integer id = 1;
        ResponseEntity<GroupsForm> response = groupsController.deleteGroup(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(11)
    void deleteGroupNull() {
        Integer id = 9;
        ResponseEntity<GroupsForm> response = groupsController.deleteGroup(id.longValue());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(12)
    void deleteCourse() {
        Integer id = 1;
        ResponseEntity<CourseForm> response = courseController.deleteCourse(id.longValue());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private GroupsForm createGroupForm() {
        GroupsForm group = new GroupsForm();
        group.setName("TDD");
        group.setNameTeacher("Bruno Vinicius");
        CourseForm course = new CourseForm();
        Integer id = 1;
        course.setId(id.longValue());
        group.setCourse(course);
        return group;
    }
}