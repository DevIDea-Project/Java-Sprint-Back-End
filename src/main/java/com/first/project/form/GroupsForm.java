package com.first.project.form;

import com.first.project.domain.Course;
import com.first.project.domain.Groups;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class GroupsForm {

    private Long id;

    @NotBlank
    private String name;

    private String nameTeacher;

    private CourseForm course;

    public List<GroupsForm> convertDomainToDto(List<Groups> groups) {
        List<GroupsForm> listaType = new ArrayList<>();
        groups.forEach(groupsDomain -> listaType.add(convertDomainToType(groupsDomain)));
        return listaType;
    }

    public GroupsForm convertDomainToType(Groups groupsDomain) {
        GroupsForm groupsType = new GroupsForm();
        groupsType.setId(groupsDomain.getId());
        groupsType.setName(groupsDomain.getName());
        groupsType.setNameTeacher(groupsDomain.getNameTeacher());

        CourseForm courseDomain = new CourseForm();
        courseDomain.setId(groupsDomain.getCourse().getId());
        courseDomain.setName(groupsDomain.getCourse().getName());
        groupsType.setCourse(courseDomain);

        return groupsType;
    }

    public Groups convertTypeToDomain(GroupsForm groupsType) {
        Groups groupsDomain = new Groups();
        groupsDomain.setId(groupsType.getId());
        groupsDomain.setName(groupsType.getName());
        groupsDomain.setNameTeacher(groupsType.getNameTeacher());

        Course courseDomain = new Course();
        courseDomain.setId(groupsType.getCourse().getId());
        groupsDomain.setCourse(courseDomain);

        return groupsDomain;
    }
}
