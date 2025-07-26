# Royal PG Website Backend

This project is a backend system for managing a Paying Guest (PG) accommodation business, built using **Spring Boot**. It provides RESTful APIs for managing tenants, buildings, and rent information, and supports features such as tenant search, Excel export, and CORS for frontend integration. The backend is designed to be deployed as a standalone service or within a Docker container.

---

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [API Overview](#api-overview)
  - [Tenant Management](#tenant-management)
  - [Building Management](#building-management)
  - [Rent Management](#rent-management)
- [Data Models](#data-models)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
  - [Locally (Maven)](#locally-maven)
  - [With Docker](#with-docker)
- [Dependencies](#dependencies)
- [Development Notes](#development-notes)
- [License](#license)

---

## Features

- **Tenant Management**: Add, update, delete, search, and list tenants. Export tenant data to Excel.
- **Building Management**: Add, delete, and list buildings.
- **Rent Management**: Set, update, and retrieve rent details for different room types.
- **Search**: Search tenants by name, guardian name, or contact number.
- **Excel Export**: Download all tenant data as an Excel file.
- **OpenAPI/Swagger**: API documentation available via Springdoc OpenAPI.

---

## Architecture

- **Spring Boot 3.5.3**: Main application framework.
- **Spring Data JPA**: ORM for MySQL database.
- **Lombok**: Reduces boilerplate code for entities and models.
- **Apache POI**: For Excel export functionality.
- **MySQL**: Primary database (configurable via environment variables).
- **Docker**: Multi-stage build for efficient containerization.

---



### Tenant

| Field              | Type        | Description                       |
|--------------------|-------------|-----------------------------------|
| id                 | Long        | Auto-generated primary key        |
| name               | String      | Tenant's name                     |
| contactNo          | String      | Tenant's contact number           |
| guardianName       | String      | Guardian's name                   |
| guardianContactNo  | String      | Guardian's contact number         |
| admissionDate      | LocalDate   | Date of admission                 |
| workPlace          | String      | Tenant's workplace                |
| aadhaarNo          | String      | Aadhaar number                    |
| building           | String      | Building name                     |
| roomNo             | String      | Room number                       |
| roomType           | String      | Room type (e.g., Single, Double)  |

### Building

| Field | Type   | Description                |
|-------|--------|----------------------------|
| id    | Long   | Auto-generated primary key |
| name  | String | Unique building name       |

### Rent

| Field     | Type    | Description                        |
|-----------|---------|------------------------------------|
| id        | Long    | Auto-generated primary key         |
| roomType  | String  | Room type (unique)                 |
| lowRent   | double  | Lower bound of rent for room type  |
| highRent  | double  | Upper bound of rent for room type  |

---


**Note:**  
Database credentials and URL are expected as environment variables for security.

---

## Running the Application

### Locally (Maven)

1. **Set up MySQL** and create a database.
2. **Set environment variables** for database connection:
   - `SPRING_DATASOURCE_URL`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
3. **Build and run:**
   ```sh
   ./mvnw spring-boot:run
   ```

### With Docker

1. **Build the Docker image:**
   ```sh
   docker build -t royalpg-backend .
   ```
2. **Run the container:**
   ```sh
   docker run -p 8080:8080 \
     -e SPRING_DATASOURCE_URL=jdbc:mysql://<host>:<port>/<db> \
     -e SPRING_DATASOURCE_USERNAME=<user> \
     -e SPRING_DATASOURCE_PASSWORD=<password> \
     royalpg-backend
   ```

---

## Dependencies

- Spring Boot (Web, Data JPA)
- MySQL Connector/J
- Lombok
- Apache POI (Excel export)
- Springdoc OpenAPI (Swagger UI)
- JUnit (testing)

