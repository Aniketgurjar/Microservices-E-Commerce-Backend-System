# Microservices E-Commerce Backend System - Product Service

## Overview

This project is a Spring Boot-based Product Service designed for an E-Commerce Microservices Architecture. It provides REST APIs for managing products and categories, supports database persistence, integrates with external services using RestTemplate, and includes centralized exception handling.

The service follows a layered architecture consisting of Controllers, Services, Repositories, DTOs, and Domain Models.

---

## Features

* Product CRUD Operations
* Category Management
* Product Search Support
* Spring Data JPA Integration
* MySQL Database Persistence
* Flyway Database Migrations
* Global Exception Handling
* DTO-Based API Design
* External API Integration using RestTemplate
* Authentication Utility Components
* Dockerized Deployment

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Validation

### Database

* MySQL
* Flyway Migration

### Search

* Elasticsearch (ProductSearch Model)

### DevOps

* Docker
* Docker Compose
* Maven

---

## Project Structure

```
src/main/java/com/example/productfinal

├── controller
│   └── ProductController

├── service
│   ├── ProductService
│   ├── SelfProductService
│   └── FakeStoreProductService

├── repositories
│   ├── ProductRepository
│   ├── CategoryRepository
│   └── ProductSearchRepository

├── models
│   ├── Product
│   ├── Category
│   ├── ProductSearch
│   └── BaseModel

├── dtos
│   ├── FakeStoreProductDto
│   ├── UserDto
│   └── Role

├── advices
│   └── ExceptionHandlerAdvice

├── commons
│   └── AuthenticationCommons

└── confige
    └── RestTemplateConfig
```

---

## Architecture

```
Client
   |
   v
ProductController
   |
   v
ProductService
   |
   +-------------------+
   |                   |
   v                   v
MySQL Database     External APIs
(JPA Repository)   (RestTemplate)
```

---

## Database Migration

Flyway is used for database version control.

Migration scripts are located at:

```
src/main/resources/db/migration
```

Current Migration:

```
V1__init.sql
```

---

## Running Locally

### Prerequisites

* Java 17+
* Maven 3.8+
* MySQL
* Docker (Optional)

### Clone Repository

```bash
git clone https://github.com/your-username/Microservices-E-Commerce-Backend-System.git
cd Microservices-E-Commerce-Backend-System
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=password
```

### Run Application

```bash
mvn clean install
mvn spring-boot:run
```

---

## API Endpoints

### Products

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| GET    | /products      | Get all products  |
| GET    | /products/{id} | Get product by ID |
| POST   | /products      | Create product    |
| PUT    | /products/{id} | Update product    |
| DELETE | /products/{id} | Delete product    |

*(Update according to your controller mappings.)*

---

## Exception Handling

The application uses a centralized exception handling mechanism via:

```java
ExceptionHandlerAdvice
```

Handled exceptions include:

* InvalidProductIdException
* ArithmeticException
* ArrayIndexOutOfBoundsException

---

## Future Enhancements

* API Gateway Integration
* Service Discovery (Eureka)
* Authentication & Authorization Service
* Kafka Event Streaming
* Redis Caching
* Elasticsearch Advanced Search
* Kubernetes Deployment
* CI/CD Pipeline

---

## Learning Outcomes

This project helped me gain hands-on experience with:

* Spring Boot Development
* REST API Design
* Spring Data JPA
* Database Migrations with Flyway
* Repository Pattern
* DTO Mapping
* Exception Handling
* Docker Basics
* Microservices Fundamentals

---

## Author

**Aniket Gurjar**

Aspiring Java Backend Developer focused on Spring Boot, Microservices, Cloud, and Distributed Systems.
