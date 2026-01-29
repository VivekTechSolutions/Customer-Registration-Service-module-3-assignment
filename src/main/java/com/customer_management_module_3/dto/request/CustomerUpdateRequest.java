package com.customer_management_module_3.dto.request;

import jakarta.validation.constraints.Size;

public class CustomerUpdateRequest {

    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    // phone is optional
    private String phone;

    // ===== Getters & Setters =====

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
