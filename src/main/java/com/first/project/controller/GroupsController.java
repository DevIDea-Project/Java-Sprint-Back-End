package com.first.project.controller;

import com.first.project.form.GroupsForm;
import com.first.project.service.GroupsService;
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
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;


    @PostMapping()
    @ResponseBody
    @Transactional
    public ResponseEntity<GroupsForm> createGroups(@Valid @RequestBody GroupsForm groupForm) {
        return new ResponseEntity<>(groupsService.saveGroups(groupForm), null  , HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseBody
    @Transactional
    public ResponseEntity<List<GroupsForm>> listGroupes() {
        return new ResponseEntity<>(groupsService.findAll(), null, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<GroupsForm> listGroupId(@PathVariable long id) {
        GroupsForm groupsForm = groupsService.findById(id);
        if(groupsForm != null) {
            return new ResponseEntity<>(groupsForm, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(groupsForm, null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<GroupsForm> updateGroup(@PathVariable long id,  @Valid @RequestBody GroupsForm groupsForm) {
        GroupsForm group = groupsService.updateCourse(id, groupsForm);
        if(group != null) {
            return new ResponseEntity<>(group, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(group, null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Transactional
    @Validated
    public ResponseEntity<GroupsForm> deleteGroup(@PathVariable long id) {
        GroupsForm groups = groupsService.deleteGroups(id);
        if (groups != null) {
            return new ResponseEntity<>(groups, null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(groups, null, HttpStatus.NOT_FOUND);
        }
    }
}
