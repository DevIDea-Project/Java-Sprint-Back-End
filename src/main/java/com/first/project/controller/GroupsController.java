package com.first.project.controller;

import com.first.project.form.GroupsForm;
import com.first.project.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
