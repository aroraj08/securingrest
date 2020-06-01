package com.spring.security.securingrest.repository;

import com.spring.security.securingrest.domain.AuthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String userName);
}
