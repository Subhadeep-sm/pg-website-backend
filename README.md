# 🏠 Royal PG Website Backend

This project is a backend system for managing a Paying Guest (PG) accommodation business, built using **Spring Boot**. It offers RESTful APIs to manage tenants, buildings, and rent-related information. The system also supports features like tenant search, Excel data export, and is fully CORS-enabled for frontend integration. Designed with scalability and maintainability in mind, it can be deployed as a standalone service or within a Docker container.

---

## Architecture

- **Spring Boot 3.5.3**: Main application framework.
- **Spring Data JPA**: ORM for MySQL database.
- **Lombok**: Reduces boilerplate code for entities and models.
- **Apache POI**: For Excel export functionality.
- **MySQL**: Primary database (configurable via environment variables).
- **Docker**: Multi-stage build for efficient containerization.

---

## ✨ Features

- ✅ **Tenant Management**: Add, update, delete, list, and search tenants. Export tenant data to Excel.
- 🏢 **Building Management**: Add, delete, and fetch all buildings.
- 💰 **Rent Management**: Set, update, and retrieve rent details for various room types.
- 🔍 **Advanced Search**: Search tenants by name, guardian name, or contact number.
- 📥 **Excel Export**: Export all tenant data to a downloadable Excel file.
- 📘 **OpenAPI / Swagger**: Interactive API documentation via Springdoc OpenAPI.





---

## 🧩 Technologies Used

- **Spring Boot** – Web and backend logic  
- **Spring Data JPA** – Database interaction  
- **MySQL** – Relational data storage  
- **Lombok** – Cleaner entity/model code  
- **Apache POI** – Excel generation  
- **Springdoc OpenAPI** – Swagger UI  
- **Docker** – Containerization  
- **JUnit** – Testing framework 

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



**Note:**  
Database credentials and URL are expected as environment variables for security.

---

**Made with ❤️ for Royal PG.**

---



