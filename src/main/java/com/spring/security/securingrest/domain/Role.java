package com.spring.security.securingrest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Roles")
@Getter
@Setter
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleType;

    @ManyToMany(mappedBy = "roles")
    private Set<AuthUser> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Role_Resource",
            joinColumns = @JoinColumn(name = "Role_Id"),
            inverseJoinColumns = @JoinColumn(name = "Resource_Id"))
    private Set<Resource> resources = new HashSet<>();
}
