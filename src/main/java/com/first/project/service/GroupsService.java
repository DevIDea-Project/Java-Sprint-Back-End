package com.first.project.service;

import com.first.project.form.GroupsForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupsService {

    public GroupsForm saveGroups(GroupsForm groupsForm);

    public GroupsForm findById(Long id);

    public GroupsForm updateCourse(Long id, GroupsForm groupsForm);

    public GroupsForm deleteGroups(Long id);

    public List<GroupsForm> findAll();
}
