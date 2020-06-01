package com.spring.security.securingrest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private String firstName;
    private String lastName;
}
