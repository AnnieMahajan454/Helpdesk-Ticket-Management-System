# Student Management API

A simple Spring Boot REST API for managing student records — built as a hands-on learning project covering CRUD operations, database persistence, input validation, centralized exception handling, and DTO-based request/response separation.

## Tech Stack

- **Java 21** (Zulu JDK)
- **Spring Boot 3.5.16**
- **Maven** (with wrapper)
- **PostgreSQL 18**
- **Postman** for API testing
- **IntelliJ IDEA Community**

## Features

- Full CRUD support for student records (Create, Read, Update, Delete)
- CGPA validation (must not exceed 4.0)
- Centralized exception handling with structured error responses
- DTO-based architecture — request and response objects are kept separate from the database entity, so internal fields are never accidentally exposed or overwritten
- PostgreSQL persistence with auto-generated primary keys (`GenerationType.IDENTITY`)

## Project Structure

```
src/main/java/com/eman/student_management_api/
├── controller/       # REST endpoints
├── service/          # Business logic and validation
├── repository/       # Spring Data JPA repository
├── model/             # JPA entity (Student)
├── dto/               # Request/response DTOs
└── exception/         # Global exception handling
```

## API Endpoints

| Method | Endpoint          | Description                  | Request Body            | Response Body      |
|--------|-------------------|-------------------------------|--------------------------|---------------------|
| POST   | `/students`       | Create a new student          | `CreateStudentRequest`  | `Student`           |
| GET    | `/students`       | Get all students               | —                        | `List<StudentResponse>` |
| GET    | `/students/{id}`  | Get a student by ID            | —                        | `StudentResponse`   |
| PUT    | `/students/{id}`  | Update a student's name/cgpa   | `UpdateStudentRequest`  | `StudentResponse`   |
| DELETE | `/students/{id}`  | Delete a student by ID          | —                        | —                    |

### Example: Create a student

**Request** — `POST /students`
```json
{
  "name": "Zara",
  "cgpa": 3.9
}
```

**Response** — `200 OK`
```json
{
  "id": 1,
  "name": "Zara",
  "cgpa": 3.9
}
```

### Validation error example

If `cgpa` exceeds `4.0`, the API returns a structured `400 Bad Request`:
```json
{
  "message": "Cgpa must be less then 4",
  "status": 400
}
```

## Setup

1. Clone the repo:
   ```
   git clone https://github.com/iman-tahir/student-management-api.git
   ```
2. Create a PostgreSQL database named `student_db`.
3. Update `src/main/resources/application.properties` with your local database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password_here
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the app:
   ```
   ./mvnw spring-boot:run
   ```
5. Test endpoints using Postman at `http://localhost:8080/students`.



## Status

Core CRUD functionality (Create, Read, Update, Delete), database integration, validation, exception handling, and DTOs are complete and tested. This project was built incrementally as a learning exercise, one concept at a time.