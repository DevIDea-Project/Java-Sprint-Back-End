package com.first.project.controller;

import com.first.project.form.CourseForm;
import com.first.project.repository.CourseRepository;
import com.first.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping()
    @Transactional
    public ResponseEntity<List<CourseForm>> list() {
        return new ResponseEntity<>(courseService.findAll(), null, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    @Transactional
    public ResponseEntity<CourseForm> create(@Valid @RequestBody CourseForm courseForm) {
        return new ResponseEntity<>(courseService.saveCourse(courseForm), HttpStatus.CREATED);
    }

}
