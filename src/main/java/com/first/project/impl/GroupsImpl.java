package com.first.project.impl;

import com.first.project.domain.Groups;
import com.first.project.form.GroupsForm;
import com.first.project.repository.GroupsRepository;
import com.first.project.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsImpl implements GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private GroupsForm groupsForm;

    @Override
    public GroupsForm saveGroups(GroupsForm groupsForm) {
        Groups groupSave = groupsRepository.save(groupsForm.convertTypeToDomain(groupsForm));
        return groupsForm.convertDomainToType(groupSave);
    }

    @Override
    public List<GroupsForm> findAll() {
        List<Groups> listGroups = groupsRepository.findAll();
        return groupsForm.convertDomainToDto(listGroups);
    }
}
