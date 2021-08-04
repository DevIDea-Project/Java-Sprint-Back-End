package com.first.project.impl;

import com.first.project.domain.Groups;
import com.first.project.form.GroupsForm;
import com.first.project.repository.GroupsRepository;
import com.first.project.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsImpl implements GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private GroupsForm groupsForm;

    @Override
    public GroupsForm saveGroups(GroupsForm groupsForm) {
        Groups groupSave = groupsRepository.save(GroupsForm.convertTypeToDomainGroups(groupsForm));
        return GroupsForm.convertDomainToTypeGroup(groupSave);
    }

    @Override
    public GroupsForm findById(Long id) {
        Optional<Groups> groupById = groupsRepository.findById(id);
        if (groupById.isPresent()) {
            return GroupsForm.convertDomainToTypeGroup(groupById.get());
        } else {
            return null;
        }
    }

    @Override
    public GroupsForm updateCourse(Long id, GroupsForm groupsForm) {
        Optional<Groups> groupsDomain = groupsRepository.findById(id);
        if (groupsDomain.isPresent()) {
            Groups groupSave = groupsDomain.get();
            groupSave.setName(groupsForm.getName());
            groupSave.setNameTeacher(groupsForm.getNameTeacher());
            return GroupsForm.convertDomainToTypeGroup(groupsRepository.saveAndFlush(groupSave));
        } else {
            return null;
        }
    }

    @Override
    public GroupsForm deleteGroups(Long id) {
        Optional<Groups> groups = groupsRepository.findById(id);
        if (groups.isPresent()) {
            Groups groups2 = groups.get();
            groupsRepository.delete(groups2);
            return GroupsForm.convertDomainToTypeGroup(groups2);
        } else {
            return null;
        }
    }

    @Override
    public List<GroupsForm> findAll() {
        List<Groups> listGroups = groupsRepository.findAll();
        return GroupsForm.convertDomainToDto(listGroups);
    }
}
