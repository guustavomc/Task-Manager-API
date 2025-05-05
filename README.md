✅ Project Overview: Task Manager REST API
You are building a Task Manager API using Spring Boot. This RESTful service allows users to:

Create, retrieve, update, and delete tasks

Organize tasks by status (e.g., pending, completed)

Integrate with a database using Spring Data JPA

Be tested using @WebMvcTest or @SpringBootTest and MockMvc

Optionally secure endpoints using Spring Security (later stage)

🛠️ Stack & Tools
Java 17+

Spring Boot

Spring Web (REST API)

Spring Data JPA

H2 / MySQL / PostgreSQL (in-memory or persistent database)

JUnit + MockMvc for testing

(Optional later) Spring Security + JWT or basic auth

🗺️ Roadmap / Milestones
🔹 1. Initial Setup
✅ Initialize Spring Boot project (done)

✅ Add required dependencies (spring-boot-starter-web, data-jpa, h2, etc.)

✅ Create main application class (TaskManagerApiApplication)

🔹 2. Core Features (CRUD)
a. Model
✅ Define Task entity with fields like: id, title, description, dueDate, status

b. Repository
✅ Create TaskRepository extending JpaRepository<Task, Long>

c. Service Layer
✅ Create TaskService to encapsulate business logic (add, update, get, delete)

d. Controller
✅ Create TaskController with REST endpoints:

GET /tasks

GET /tasks/{id}

POST /tasks

PUT /tasks/{id}

DELETE /tasks/{id}

🔹 3. Testing
✅ Unit test TaskController using @WebMvcTest

✅ Use MockMvc to simulate HTTP requests

❗Optionally test TaskService (unit test with mocks)

🔹 4. Data Validation & Error Handling
⏳ Use @Valid and @NotNull, @Size, etc. on request DTOs

⏳ Create custom error responses using @ControllerAdvice

🔹 5. Advanced Features (Optional / Later)
⏳ Filtering tasks by status or due date (e.g., GET /tasks?status=completed)

⏳ Add pagination support

⏳ Spring Security with login or token authentication

⏳ Dockerize the app

⏳ Deploy to Heroku, Render, or Railway

