package com.first.project.form;

import com.first.project.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserForm {

    private Long id;
    private String name;
    private String email;
    private String senha;

    public User convertDtoToDomain(UserForm userDto) {
        User userDomain = new User();
        userDomain.setId(userDto.getId());
        userDomain.setEmail(userDto.getEmail());
        userDomain.setName(userDto.getName());
        userDomain.setSenha(userDto.getSenha());
        return userDomain;
    }

    public UserForm convertDomainToDto (User userDomain) {
        UserForm userDto = new UserForm();
        userDto.setId(userDomain.getId());
        userDto.setEmail(userDomain.getEmail());
        userDto.setName(userDomain.getName());
        userDto.setSenha(userDomain.getPassword());
        return userDto;
    }

    public List<UserForm> convertListDomainToDto (List<User> listDomain){
        List<UserForm> listDto = new ArrayList<>();
        listDomain.forEach(userDomain -> {
            UserForm user = new UserForm();
            user.setId(userDomain.getId())	;
            user.setName(userDomain.getName());
            user.setEmail(userDomain.getEmail());
            listDto.add(user);
        });
        return listDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
