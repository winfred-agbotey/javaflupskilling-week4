# Part Two Spring Boot Application

This is a simple **Spring Boot web application** generated using [Spring Initializr](https://start.spring.io/). It includes basic dependencies for building RESTful web services with Spring Boot.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)
- [API Endpoints](#api-endpoints)
- [Technologies Used](#technologies-used)
- [Author](#author)

---

## Features
- RESTful API with Spring Boot.
- Supports easy configuration using `application.properties`.
- Example endpoint to return a **Hello Spring Boot** message.

---


## Project Structure
demo/ ├── src/ │ ├── main/java/com/example/demo/ │ │ ├── DemoApplication.java │ │ └── controller/WelcomeController.java │ └── resources/ │ ├── application.properties │ └── application-dev.properties └── pom.xml

## Prerequisites
- **Java** 17+ installed (Ensure `JAVA_HOME` is configured).
- **Maven** 3.8+ installed.
- An IDE (like IntelliJ IDEA, VS Code, or Eclipse).
- **Git** installed.

---

## How to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/winfred-agbotey/javaflupskilling-week4.git
   cd parttwo

## Build the project using Maven:
```bash
    Copy code
    mvn clean install
```

## Run the application:
```bash
Copy code
mvn spring-boot:run
```

## Open your browser and go to:
```arduino
    Copy code
    http://localhost:8080
```

## API Endpoints
| **Method** | **Endpoint**   | **Description**            | **Example Response**                                                                                                 |
|------------|----------------|----------------------------|----------------------------------------------------------------------------------------------------------------------|
| GET        | `/api/welcome` | Returns a greeting message | `"Welcome to the Demo Spring Boot Application!" (default) / "Welcome to the Development Environment!" (development)` |

## Technologies Used
- Java 17+
- Spring Boot 3.x
- Maven (Build tool)
- Git (Version control)

## Author
Developed by [Winfred Mawuli Agbotey](https://github.com/winfred-agbotey/). Feel free to contribute or report issues!