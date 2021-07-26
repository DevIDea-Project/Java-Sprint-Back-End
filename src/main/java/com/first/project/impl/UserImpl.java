package com.first.project.impl;

import com.first.project.domain.User;
import com.first.project.form.UserForm;
import com.first.project.repository.UserRepository;
import com.first.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserForm userForm;

    @Override
    public UserForm saveUser(UserForm userType) {
        userType.setSenha(new BCryptPasswordEncoder().encode(userType.getSenha()));
        User userSave = userRepository.save(userForm.convertDtoToDomain(userType));
        return userForm.convertDomainToDto(userSave);
    }

    @Override
    public List<UserForm> findAllByOrderByNomeBrand() {
        List<User> listUser = userRepository.findAllByOrderByNameAsc();
        return userForm.convertListDomainToDto(listUser);
    }

    @Override
    public UserForm removeUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User user2 = user.get();
            userRepository.delete(user2);
            return userForm.convertDomainToDto(user2);
        } else {
            return null;
        }
    }
}
