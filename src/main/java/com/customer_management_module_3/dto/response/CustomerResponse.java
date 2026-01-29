package com.customer_management_module_3.dto.response;

import java.time.LocalDateTime;

public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime registeredDate;

    // getters & setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }
    
    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }
}