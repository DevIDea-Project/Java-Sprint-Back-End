package com.first.project.controller;

import com.first.project.form.StudentForm;
import com.first.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping()
    @ResponseBody
    @Transactional
    public ResponseEntity<StudentForm> createStudent(@Valid @RequestBody StudentForm studentForm) {
        return new ResponseEntity<>(studentService.saveStudent(studentForm), null  , HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseBody
    @Transactional
    public ResponseEntity<List<StudentForm>> listStudent() {
        return new ResponseEntity<>(studentService.findAll(), null, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<StudentForm> listStudentId(@PathVariable long id) {
        StudentForm studentForm = studentService.findByIdStudent(id);
        if(studentForm != null) {
            return new ResponseEntity<>(studentForm, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(studentForm, null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<StudentForm> updateStudent(@PathVariable long id,  @Valid @RequestBody StudentForm studentForms) {
        StudentForm studentFormUpdate = studentService.updateStudent(id, studentForms);
        if(studentFormUpdate != null) {
            return new ResponseEntity<>(studentFormUpdate, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(studentFormUpdate, null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Transactional
    @Validated
    public ResponseEntity<StudentForm> deleteStudent(@PathVariable long id) {
        StudentForm studentFormDelete = studentService.deleteStudent(id);
        if (studentFormDelete != null) {
            return new ResponseEntity<>(studentFormDelete, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(studentFormDelete, null, HttpStatus.NOT_FOUND);
        }
    }
}
