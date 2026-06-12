# Task Manager REST API

A RESTful API for managing tasks, built with Spring Boot. This project allows users to create, retrieve, update, and delete tasks, organize them by status, and integrate with a database using Spring Data JPA. The API is designed to be testable, extensible, and secure (with optional Spring Security in later stages).

## ✅ Project Overview

The Task Manager API enables users to:

- Create, retrieve, update, and delete tasks
- Organize tasks by status (e.g., pending, completed)
- Integrate with a database using Spring Data JPA
- Be tested using `@WebMvcTest` or `@SpringBootTest` and MockMvc
- Optionally secure endpoints using Spring Security (planned for later stages)

## 🛠️ Stack & Tools

- **Java**: 17+
- **Spring Boot**: Framework for building the application
- **Spring Web**: For creating RESTful APIs
- **Spring Data JPA**: For database integration
- **H2 Database**: In-memory database for development and testing (MySQL/PostgreSQL support planned)
- **JUnit + MockMvc**: For unit and integration testing
- **(Optional later)** Spring Security with JWT or basic authentication

## 📦 Package and Class Structure

The project follows a clean, layered architecture with packages organized by responsibility. Below is the structure of the source code:

```
Task-Manager-API
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.task_manager_api
│   │   │       ├── controller
│   │   │       │   └── TaskController.java      # REST controller for task endpoints
│   │   │       ├── model
│   │   │       │   ├── Task.java               # Task entity
│   │   │       │   └── TaskStatus.java         # Enum for task status
│   │   │       │   └── TaskRequest.java        # TaskRequest DTO
│   │   │       ├── repository
│   │   │       │   └── TaskRepository.java     # JPA repository for Task entity
│   │   │       ├── service
│   │   │       │   └── TaskService.java        # Service layer for business logic
│   │   │       └── TaskManagerApiApplication.java  # Main Spring Boot application class
│   │   └── resources
│   │       └── application.properties          # Application configuration
│   └── test
│       ├── java
│       │   └── com.example.task_manager_api
│       │       ├── controller
│       │       │   └── TaskControllerTest.java  # Tests for TaskController
│       │       ├── service
│       │       │   └── TaskServiceTest.java     # Tests for TaskService
│       │       └── TaskManagerApiApplicationTests.java  # Application context tests
└── pom.xml                                      # Maven dependencies and build configuration
```

### Package Descriptions

- **`com.example.task_manager_api.controller`**: Contains REST controllers (e.g., `TaskController`) that handle HTTP requests and responses.
- **`com.example.task_manager_api.model`**: Defines the data models, including the `Task` entity and `TaskStatus` enum.
- **`com.example.task_manager_api.repository`**: Contains Spring Data JPA repositories (e.g., `TaskRepository`) for database operations.
- **`com.example.task_manager_api.service`**: Implements business logic in service classes (e.g., `TaskService`).
- **`com.example.task_manager_api` (root package)**: Contains the main application class (`TaskManagerApiApplication`).

Tests are organized similarly under `src/test/java`, mirroring the main package structure for clarity.

## 🗺️ Roadmap / Milestones

### 🔹 1. Initial Setup
- ✅ Initialize Spring Boot project (done)
- ✅ Add required dependencies (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `h2`, `spring-boot-starter-test`)
- ✅ Create main application class (`TaskManagerApiApplication`)

### 🔹 2. Core Features (CRUD)
#### a. Model
- ✅ Define `Task` entity with fields: `id`, `taskName`, `description`, `dueDate`, `status`, `tags`
- ✅ Define `TaskStatus` enum for task status (e.g., `TODO`, `IN_PROGRESS`, `DONE`)

#### b. Repository
- ✅ Create `TaskRepository` extending `JpaRepository<Task, Long>`

#### c. Service Layer
- ✅ Create `TaskService` to encapsulate business logic (add, update, get, delete)

#### d. Controller
- ✅ Create `TaskController` with REST endpoints:
    - `GET    /api/task`             → List all tasks
    - `POST   /api/task`             → Create a task
    - `GET    /api/task/{id}`        → Get task by ID
    - `PUT    /api/task/{id}`        → Update a task
    - `DELETE /api/task/{id}`        → Delete a task
    - `GET    /api/task/status/{status}`    → Filter by status
    - `GET    /api/task/due?before=...`     → Tasks due before date

### 🔹 3. Testing
- ✅ Test `TaskService` (unit test with mocks)
- ✅ Unit test `TaskController` using `@SpringBootTest` and MockMvc
- ✅ Use MockMvc to simulate HTTP requests

### 🔹 4. Data Validation & Error Handling
- ✅ Use `@Valid`, `@NotNull`, `@Size`, etc., on request DTOs
- ⏳ Create custom error responses using `@ControllerAdvice`

### 🔹 5. Advanced Features (Optional / Later)
- ⏳ Filtering tasks by status or due date (e.g., `GET /api/task?status=completed`)
- ⏳ Add pagination support
- ⏳ Spring Security with login or token authentication
- ⏳ Dockerize the app
- ⏳ Deploy to Heroku, Render, or Railway

## ✅ Milestone Plan

### Milestone 1: Basic CRUD
- Set up Spring Boot project ✅
- Define `Task` model and enum ✅
- Create repository with Spring Data JPA ✅
- Build controller and service for CRUD ✅
- Validate input (e.g., `taskName` not blank) ✅

### Milestone 2: Testing
- Add unit tests for the service layer ✅
- Add integration tests for controllers using `@SpringBootTest` ✅

### Milestone 3: Extras
- Use Docker + PostgreSQL ⏳
- Add filtering endpoints ⏳
- Add Swagger/OpenAPI documentation ⏳
- Optional: Add authentication (JWT) ⏳

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Maven** for dependency management and building the project

### Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd Task-Manager-API
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
   The API will be available at `http://localhost:8080`.

4. **Access the H2 Console** (for development):
    - URL: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:testdb`
    - Username: `sa`
    - Password: (leave blank)

### Testing the API
- Use tools like Postman or curl to test the endpoints.
- Example: Create a task
  ```bash
  curl -X POST http://localhost:8080/api/task \
  -H "Content-Type: application/json" \
  -d '{"taskName":"Test Task","description":"Some Description","status":"TODO","dueDate":"2025-05-10","tags":["work","test"]}'
  ```

### Running Tests
- Run all tests:
  ```bash
  mvn test
  ```
- Tests are located in `src/test/java/com/example/task_manager_api`.

## 📋 API Endpoints

| Method | Endpoint                      | Description                  |
|--------|-------------------------------|------------------------------|
| GET    | `/api/task`                   | List all tasks               |
| POST   | `/api/task`                   | Create a new task            |
| GET    | `/api/task/{id}`              | Get task by ID               |
| PUT    | `/api/task/{id}`              | Update a task                |
| DELETE | `/api/task/{id}`              | Delete a task                |
| GET    | `/api/task/status/{status}`   | Filter tasks by status       |
| GET    | `/api/task/due?before=...`    | Get tasks due before a date  |

## 🛡️ Security (Planned)
- Add Spring Security with JWT or basic authentication to secure endpoints.

## 📄 License
This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing
Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request.