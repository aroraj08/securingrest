package com.spring.security.securingrest;

import com.spring.security.securingrest.domain.AuthUser;
import com.spring.security.securingrest.domain.Role;
import com.spring.security.securingrest.repository.RoleRepository;
import com.spring.security.securingrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@SpringBootApplication
public class SecuringRestApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SecuringRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // setup dummy admin user
        String password = "admin123";
        String encodedPwd = this.passwordEncoder.encode(password);
        AuthUser adminUser = new AuthUser(null, encodedPwd, "admin",
                new HashSet<>(), true, true, true, true);
        Optional<Role> adminRole= roleRepository.findByRoleType("Admin");
        if(adminRole.isPresent()){
            adminUser.setRoles(new HashSet<Role>(Arrays.asList(adminRole.get())));
        }
        this.userRepository.save(adminUser);

        // setup dummy user
        String userPassword = "abc123";
        String userEncodedPwd = this.passwordEncoder.encode(userPassword);

        AuthUser user = new AuthUser(null, userEncodedPwd, "jatin",
                new HashSet<>(), true, true, true, true);
        Optional<Role> userRole= roleRepository.findByRoleType("User");
        if(userRole.isPresent()){
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole.get())));
        }
        this.userRepository.save(user);
    }
}
