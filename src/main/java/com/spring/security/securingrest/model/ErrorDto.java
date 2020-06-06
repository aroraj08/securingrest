package com.spring.security.securingrest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private String status;
    private String errorMessage;
    private String description;

}
