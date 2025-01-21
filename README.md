# Java Spring Boot Project: CRUD Operations with MongoDB

This project is a basic Java application built with Spring Boot and Maven that demonstrates CRUD (Create, Read, Update, Delete) operations on a MongoDB instance using the MongoDB Java Driver. The project is configured to run in IntelliJ IDEA.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Project Setup](#project-setup)
3. [Features](#features)
4. [How to Run](#how-to-run)
5. [Code Structure](#code-structure)
6. [Dependencies](#dependencies)
7. [Usage](#usage)
8. [Contributing](#contributing)


---

## Prerequisites

Before running this project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MongoDB (LocalDB instance)
- IntelliJ IDEA

## Project Setup

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd <repository_name>
   ```

2. **Open the Project in IntelliJ IDEA**
   - Launch IntelliJ IDEA.
   - Select **Open** and navigate to the project directory.
   - Wait for Maven to resolve dependencies.

3. **Configure MongoDB**
   - Ensure MongoDB is running locally on `localhost:27017`.
   - Create a database and collection for testing CRUD operations.

4. **Update Configuration**
   - Modify the MongoDB connection URI in the `application.properties` file:
     ```properties
     spring.data.mongodb.uri=mongodb://localhost:27017/<your_database_name>
     ```

## Features

- **Create:** Insert new documents into the MongoDB collection.
- **Read:** Retrieve and query documents from the collection.
- **Update:** Modify existing documents.
- **Delete:** Remove documents from the collection.

## How to Run

1. Start MongoDB:
   ```bash
   mongosh
   ```

2. Run the application:
   - In IntelliJ IDEA, run the `main` method in the Spring Boot application class (annotated with `@SpringBootApplication`).

3. Access the application:
   - The application runs on `http://localhost:8080` by default.

## Code Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.crud/  # Your package
│   │       ├── model/         # Data models
│   │       ├── repository/    # MongoDB interaction logic
│   │       ├── service/       # Business logic
│   │       ├── controller/    # REST controllers
│   │       └── CrudApplication.java # Main entry point
│   └── resources/
│       ├── application.properties # Configuration file
│       └── static/           # Static resources (if any)
└── test/
    └── java/                  # Unit tests
```

## Dependencies

The project uses the following Maven dependencies:

```xml
<dependencies>
    <!-- Spring Boot Starter Data MongoDB -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Additional dependencies (e.g., Lombook) -- and few others-->

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Usage

### Example CRUD Operations via REST API

**Create Document:**
- Endpoint: `POST /api/documents`
- Example Request Body:
  ```json
  {
      "name": "John Doe",
      "age": 30
  }
  ```

**Read Documents:**
- Endpoint: `GET /api/documents`
- Example Response:
  ```json
  [
      {
          "id": "<document_id>",
          "name": "John Doe",
          "age": 30
      }
  ]
  ```

**Update Document:**
- Endpoint: `PUT /api/documents/{id}`
- Example Request Body:
  ```json
  {
      "name": "John Doe",
      "age": 31
  }
  ```

**Delete Document:**
- Endpoint: `DELETE /api/documents/{id}`

## Contributing

Contributions are welcome! Please submit a pull request or raise an issue for suggestions and improvements.

**Happy Coding!**

