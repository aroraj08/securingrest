package com.spring.security.securingrest.service;

import com.spring.security.securingrest.domain.AuthUser;
import com.spring.security.securingrest.domain.Resource;
import com.spring.security.securingrest.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<AuthUser> authUserOptional = this.userRepository.findUserDetailsByUsername(userName);
        //Optional<AuthUser> authUserOptional = this.userRepository.findByUsername(userName);
        AuthUser authUser = authUserOptional.orElseThrow(() -> new UsernameNotFoundException("No User found"));

        Set<Resource> resources = authUser.getRoles().stream()
            .flatMap(role -> role.getResources().stream())
                .collect(Collectors.toSet());
        User user = new User(authUser.getUsername(), authUser.getPassword(), resources);
        return user;
    }
}
