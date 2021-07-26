package com.first.project.service;

import com.first.project.exception.UserException;
import com.first.project.form.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserForm saveUser(UserForm userForm) throws UserException;

    public List<UserForm> findAllByOrderByNomeBrand();

    public UserForm removeUser(Long id);
}
