package com.spring.security.securingrest.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resource implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resource;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AuthUser authUser;

    @Override
    public String getAuthority() {
        return resource;
    }
}
