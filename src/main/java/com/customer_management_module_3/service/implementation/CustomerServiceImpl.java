package com.customer_management_module_3.service.implementation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.customer_management_module_3.dto.request.CustomerCreateRequest;
import com.customer_management_module_3.dto.request.CustomerUpdateRequest;
import com.customer_management_module_3.dto.response.CustomerResponse;
import com.customer_management_module_3.entity.Customer;
import com.customer_management_module_3.exception.CustomerNotFoundException;
import com.customer_management_module_3.repository.CustomerRepository;
import com.customer_management_module_3.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerResponse registerCustomer(CustomerCreateRequest request) {

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setRegisteredDate(LocalDateTime.now());

        Customer saved = repository.save(customer);
        return mapToResponse(saved);
    }

    @Override
    public CustomerResponse getCustomerByEmail(String email) {
        Customer customer = repository.findByEmail(email)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        return mapToResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(String email, CustomerUpdateRequest request) {

        Customer customer = repository.findByEmail(email)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setName(request.getName());
        customer.setPhone(request.getPhone());

        return mapToResponse(repository.save(customer));
    }

    private CustomerResponse mapToResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setRegisteredDate(customer.getRegisteredDate());
        return response;
    }
}

