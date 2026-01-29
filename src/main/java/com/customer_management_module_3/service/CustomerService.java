package com.customer_management_module_3.service;

import com.customer_management_module_3.dto.request.CustomerCreateRequest;
import com.customer_management_module_3.dto.request.CustomerUpdateRequest;
import com.customer_management_module_3.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerCreateRequest request);

    CustomerResponse getCustomerByEmail(String email);

    CustomerResponse updateCustomer(String email, CustomerUpdateRequest request);
}