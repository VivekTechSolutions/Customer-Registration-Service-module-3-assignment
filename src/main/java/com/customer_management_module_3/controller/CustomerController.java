package com.customer_management_module_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customer_management_module_3.dto.request.CustomerCreateRequest;
import com.customer_management_module_3.dto.request.CustomerUpdateRequest;
import com.customer_management_module_3.dto.response.CustomerResponse;
import com.customer_management_module_3.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers") 
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    // Register a new customer
    public ResponseEntity<CustomerResponse> register(
            @Valid @RequestBody CustomerCreateRequest request) {

        CustomerResponse response = service.registerCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{email}")
    // Get customer details by email
    public ResponseEntity<CustomerResponse> getByEmail(@PathVariable String email) {

        CustomerResponse response = service.getCustomerByEmail(email);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{email}")
    // Update customer details by email
    public ResponseEntity<CustomerResponse> update(
            @PathVariable String email,
            @Valid @RequestBody CustomerUpdateRequest request) {

        CustomerResponse response = service.updateCustomer(email, request);
        return ResponseEntity.ok(response);
    }
}
