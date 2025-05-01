# Library Management System - Spring Boot API

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![License](https://img.shields.io/badge/License-Apache%202.0-blue)

A RESTful API for managing library operations, including book and patron management, borrowing records, and transaction handling. Built with Spring Boot and designed for scalability, security, and ease of use.

---

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Testing](#testing)
- [License](#license)
- [Acknowledgments](#acknowledgments)



## Features
- **Book Management**: Full CRUD operations for books (title, author, ISBN, publication year).
- **Patron Management**: CRUD operations for patrons (name, contact information).
- **Borrowing System**: Track book borrow/return dates with transactional integrity.
- **Input Validation**: Validate ISBN formats, publication years, and required fields.
- **Security** (Optional): JWT-based authentication for protected endpoints.
- **Database Support**: Configurable for H2 (in-memory) or PostgreSQL.
- **API Documentation**: Integrated Swagger UI for endpoint exploration.

---

## Technologies
- **Backend Framework**: Spring Boot 3.x
- **Database**: MySql
- **ORM**: Spring Data JPA, Hibernate
- **Security**: Spring Security, JWT (optional)
- **Build Tool**: Maven
- **API Documentation**: SpringDoc OpenAPI 3


---

## Prerequisites
- Java 17 or later
- Maven 3.8+

---

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Mahmoudyounes011/library-management-
   cd library-management-system
