package com.spring.security.securingrest.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "resources")
    private Set<Role> roles;

    @Override
    public String getAuthority() {
        return resource;
    }
}
