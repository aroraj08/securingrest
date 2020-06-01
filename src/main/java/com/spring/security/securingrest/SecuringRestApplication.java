package com.spring.security.securingrest;

import com.spring.security.securingrest.domain.AuthUser;
import com.spring.security.securingrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class SecuringRestApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecuringRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String password = "admin123";
        String encodedPwd = this.passwordEncoder.encode(password);
        AuthUser adminUser = new AuthUser(null, encodedPwd, "admin",
                new HashSet<>(), true, true, true, true);
        this.userRepository.save(adminUser);
    }
}
