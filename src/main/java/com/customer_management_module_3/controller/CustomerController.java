package com.customer_management_module_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_management_module_3.dto.request.CustomerCreateRequest;
import com.customer_management_module_3.dto.request.CustomerUpdateRequest;
import com.customer_management_module_3.dto.response.CustomerResponse;
import com.customer_management_module_3.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponse register(@Valid @RequestBody CustomerCreateRequest request) {
        return service.registerCustomer(request);
    }

    @GetMapping("/{email}")
    public CustomerResponse getByEmail(@PathVariable String email) {
        return service.getCustomerByEmail(email);
    }

    @PutMapping("/{email}")
    public CustomerResponse update(
        @PathVariable String email,
        @Valid @RequestBody CustomerUpdateRequest request) {

        return service.updateCustomer(email, request);
    }
}
