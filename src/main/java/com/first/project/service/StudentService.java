package com.first.project.service;

import com.first.project.form.StudentForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentForm saveStudent(StudentForm studentForm);

    public List<StudentForm> findAll();

    public StudentForm findByIdStudent(Long id);

    public StudentForm updateStudent(Long id, StudentForm studentForm);

    public StudentForm deleteStudent(Long id);
}
