package com.spring.security.securingrest.repository;

import com.spring.security.securingrest.domain.AuthUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String userName);

    @Query("SElECT distinct u from AuthUser u JOIN FETCH u.roles r JOIN FETCH r.resources WHERE u.username = :userName")
    Optional<AuthUser> findUserDetailsByUsername(@Param("userName") String userName);
}
