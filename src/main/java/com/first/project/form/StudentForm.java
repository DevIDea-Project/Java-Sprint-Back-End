package com.first.project.form;

import com.first.project.domain.Course;
import com.first.project.domain.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class StudentForm {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private CourseForm course;


    public static List<StudentForm> convertDomainToDto(List<Student> student) {
        List<StudentForm> listaType = new ArrayList<>();
        student.forEach(studentDomain -> listaType.add(convertDomainToTypeStudent(studentDomain)));
        return listaType;
    }

    public static StudentForm convertDomainToTypeStudent(Student studentDomain) {
        StudentForm studentType = new StudentForm();

        studentType.setId(studentDomain.getId());
        studentType.setName(studentType.getName());
        studentType.setAddress(studentType.getAddress());
        studentType.setPhoneNumber(studentType.getPhoneNumber());

        CourseForm courseDomain = new CourseForm();
        courseDomain.setId(studentDomain.getCourse().getId());
        courseDomain.setName(studentDomain.getCourse().getName());
        studentType.setCourse(courseDomain);

        return studentType;
    }

    public static Student convertTypeToDomainStudent(StudentForm studentType) {
        Student studentDomain = new Student();
        studentDomain.setId(studentType.getId());
        studentDomain.setName(studentType.getName());
        studentDomain.setAddress(studentType.getAddress());
        studentDomain.setPhoneNumber(studentType.getPhoneNumber());

        Course courseDomain = new Course();
        courseDomain.setId(studentType.getCourse().getId());
        studentDomain.setCourse(courseDomain);

        return studentDomain;
    }


}
