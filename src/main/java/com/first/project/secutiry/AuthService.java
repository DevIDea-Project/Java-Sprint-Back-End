package com.first.project.secutiry;

import com.first.project.domain.User;
import com.first.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user = repository.findByEmail(username);

        if(user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("Dados Invalidos!");
    }
}
