package com.spring.security.securingrest.controller;

import com.spring.security.securingrest.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @PreAuthorize("hasAuthority('User_Read')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(CustomerDto.builder()
                .firstName("Jatin")
                .lastName("Arora").build());
    }

    @PreAuthorize("hasAuthority('Admin_Read')")
    @GetMapping("/customer/all")
    public ResponseEntity<Set<CustomerDto>> allCustomersRecords() {

        Set<CustomerDto> customerSet = new HashSet<>();
        customerSet.add(CustomerDto.builder()
                .firstName("Jatin")
                .lastName("Arora").build());

        customerSet.add(CustomerDto.builder()
                .firstName("Kapil")
                .lastName("Arora").build());

        return ResponseEntity.ok(customerSet);
    }

}
