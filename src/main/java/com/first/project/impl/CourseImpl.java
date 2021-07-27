package com.first.project.impl;

import com.first.project.domain.Course;
import com.first.project.form.CourseForm;
import com.first.project.repository.CourseRepository;
import com.first.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseForm courseForm;


    @Override
    public CourseForm saveCourse(CourseForm courseType) {
        Course courseSave = courseRepository.save(CourseForm.convertTypeToDomain(courseType));
        return CourseForm.convertDomainToType(courseSave);
    }

    @Override
    public List<CourseForm> findAll() {
        List<Course> listCourse = courseRepository.findAll();
        return CourseForm.convertDomainToDto(listCourse);
    }

    @Override
    public CourseForm findByIdCourse(Long id) {
        Optional<Course> courseById = courseRepository.findById(id);
        if (courseById.isPresent()) {
            return CourseForm.convertDomainToType(courseById.get());
        } else {
            return null;
        }
    }

    @Override
    public CourseForm updateCourse(Long id, CourseForm courseForm) {
        Optional<Course> courseDomain = courseRepository.findById(id);
        if (courseDomain.isPresent()) {
            Course courseSave = courseDomain.get();
            courseSave.setName(courseForm.getName());
            return CourseForm.convertDomainToType(courseRepository.saveAndFlush(courseSave));
        } else {
            return null;
        }
    }

    @Override
    public CourseForm deleteCourse(Long id) {
        Optional<Course> course1 = courseRepository.findById(id);
        if (course1.isPresent()) {
            Course course2 = course1.get();
            courseRepository.delete(course2);
            return CourseForm.convertDomainToType(course2);
        } else {
            return null;
        }
    }
}
