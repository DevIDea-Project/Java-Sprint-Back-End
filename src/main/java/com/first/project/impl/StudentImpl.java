package com.first.project.impl;

import com.first.project.domain.Student;
import com.first.project.form.StudentForm;
import com.first.project.repository.StudentRepository;
import com.first.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentForm studentForm;

    @Override
    public StudentForm saveStudent(StudentForm studentForm) {
        Student studentSave = studentRepository.save(StudentForm.convertTypeToDomainStudent(studentForm));
        return StudentForm.convertDomainToTypeStudent(studentSave);
    }

    @Override
    public List<StudentForm> findAll() {
        List<Student> listGroups = studentRepository.findAll();
        return StudentForm.convertDomainToDto(listGroups);
    }

    @Override
    public StudentForm findByIdStudent(Long id) {
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isPresent()) {
            return StudentForm.convertDomainToTypeStudent(studentById.get());
        } else {
            return null;
        }
    }

    @Override
    public StudentForm updateStudent(Long id, StudentForm studentForm) {
        Optional<Student> studentDomain = studentRepository.findById(id);
        if (studentDomain.isPresent()) {
            Student studentSave = studentDomain.get();
            studentSave.setName(studentSave.getName());
            studentSave.setAddress(studentSave.getAddress());
            studentSave.setPhoneNumber(studentSave.getPhoneNumber());
            return StudentForm.convertDomainToTypeStudent(studentRepository.saveAndFlush(studentSave));
        } else {
            return null;
        }
    }

    @Override
    public StudentForm deleteStudent(Long id) {

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student student2 = student.get();
            studentRepository.delete(student2);
            return StudentForm.convertDomainToTypeStudent(student2);
        } else {
            return null;
        }

    }
}
