package com.first.project.service;

import com.first.project.form.GroupsForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupsService {

    public GroupsForm saveGroups(GroupsForm groupsForm);

    public List<GroupsForm> findAll();
}
