# CourseHub - Spring Boot Backend Project

## Overview

CourseHub is a backend application built using Spring Boot.
It provides REST APIs for user authentication and course management with secure JWT-based authentication.

---

## Features

* User Registration and Login
* JWT Authentication (token-based security)
* Layered Architecture (Controller to Service to Repository)
* MySQL Database Integration using JPA and Hibernate
* Many-to-Many Relationship (Student and Course)
* Global Exception Handling
* Protected APIs using Spring Security

---

## Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA (Hibernate)
* MySQL
* JWT (io.jsonwebtoken)

---

## Project Structure

```id="vfhx5y"
coursehub/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 ├── exception/
 ├── config/
 ├── util/
 └── resources/
```

---

## Setup and Run

### 1. Clone the repository

```id="vsm8jo"
git clone <your-repo-link>
```

### 2. Create Database

```id="d39wsm"
CREATE DATABASE coursehub;
```

### 3. Update application.properties

```id="2d3ppl"
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Run the application

* Open project in IntelliJ
* Run CoursehubApplication.java

---

## Authentication Flow

1. User logs in using /auth/login
2. Server generates JWT token
3. Token must be sent in header

```id="h8gk7m"
Authorization: Bearer <token>
```

4. Backend validates token using JWT filter

---

## API Endpoints

### Auth

* POST /auth/register
* POST /auth/login

### Courses

* GET /courses
* POST /courses

### Students

* GET /students
* POST /students/{id}/enroll/{courseId}

---

## Key Learning

* Implemented JWT Authentication in Spring Boot
* Understood Spring Security filter chain
* Built REST APIs with proper structure
* Worked with JPA relationships

---

## Author

* Your Name

---

## Notes

This project focuses on backend development and API design using Spring Boot.
