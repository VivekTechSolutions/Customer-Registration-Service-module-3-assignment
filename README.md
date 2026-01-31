🧩 Problem Statement
=======================

In real-world applications, customer information must be stored and managed securely and accurately.
Common challenges include:

Invalid email formats
Incomplete or inconsistent customer data
Exposing internal database entities directly through APIs
Poor error messages for validation failures
This module addresses these issues by designing a clean, validated, and well-structured Customer Registration Service.

🎯 Functional Requirements
=============================

The system provides the following REST APIs:
--------------------------------------------
Register a new customer
**********************
Retrieve customer details using email

Update existing customer details

Each API enforces validation rules and returns meaningful responses.

🧾 Entity Definition
********************
Customer

Represents a registered customer in the system.

Attributes:

id – Unique identifier
name – Customer name
email – Unique email address
phone – Optional contact number
registeredDate – Date of registration

✅ Validation Rules
-------------------

The application enforces strict validation to ensure data quality:

Email must follow a valid email format

Name must have a minimum length
Phone number is optional
Duplicate customer registration using the same email is prevented
Validation errors return clear and meaningful messages instead of generic system errors.

🧩 DTO Rules
===============

To maintain clean API design:
-------------------------------

Database entities are never returned directly

Separate DTOs are used for:
Customer creation requests
Customer update requests
Customer response payloads

This ensures:

Loose coupling between API and database

Better security
Easier future changes

🏗️ Design & Layered Architecture
=================================

The application follows a layered architecture, where each layer has a clear role.

Controller Layer
------------------

Handles incoming HTTP requests

Accepts and returns DTOs
Delegates processing to the service layer
Contains no business logic

Service Layer
-----------

Contains all business rules

Handles customer registration logic
Validates business constraints
Coordinates between controller and repository

Repository Layer
------------------

Manages database operations
Uses Spring Data JPA
Contains no business logic

Entity Layer
-----------
Represents database tables
Used only internally
Never exposed to API consumers

Exception Handling 
-----------------

Centralized error handling using global exception handler
Converts validation and business exceptions into user-friendly responses
Ensures consistent error formats across APIs

📦 Deliverables
=============

This project delivers:
----------------------------

Fully working Spring Boot application

REST API endpoints for customer management
Input validation with meaningful error messages
Sample validation error responses
Clean, modular, and scalable codebase
