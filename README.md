# Expense Tracker Backend

A RESTful backend application built using Spring Boot and PostgreSQL for managing income and expense transactions with secure JWT-based authentication.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

## ✨ Features

### Authentication & Authorization

- User Registration
- User Login
- JWT Token Generation
- Protected APIs using Spring Security
- Stateless Authentication

### Transaction Management

- Add income and expenses
- Update transactions
- Delete transactions
- View transaction history
- Category-wise tracking

### Backend Architecture

- RESTful APIs
- Layered Architecture
- Exception Handling
- JPA Repository Pattern

---

## 📂 Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util

---

## 🔐 Authentication APIs

### Register User

POST

/api/auth/register

Request Body

```json
{
  "name": "Anjali",
  "email": "anjali@gmail.com",
  "password": "password123"
}
```

### Login User

POST

/api/auth/login

Request Body

```json
{
  "email": "anjali@gmail.com",
  "password": "password123"
}
```

Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

## 📌 Transaction APIs

| Method | Endpoint |
|----------|----------|
| GET | /api/transactions |
| GET | /api/transactions/{id} |
| POST | /api/transactions |
| PUT | /api/transactions/{id} |
| DELETE | /api/transactions/{id} |

---

## 🗄 Database

PostgreSQL

Tables:

- users
- transactions

---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/your-username/expense-tracker-backend.git
```

### Configure application.properties

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=
jwt.expiration=
```

### Run

```bash
mvn spring-boot:run
```

Server starts at:

http://localhost:8080

---

## 🏗 Architecture

React Frontend
      ↓
Axios
      ↓
JWT Token
      ↓
Spring Security Filter
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
PostgreSQL Database

---

## 🔒 Security Flow

User Login
      ↓
JWT Token Generated
      ↓
Frontend Stores Token
      ↓
Authorization Header

Bearer <token>

      ↓
Spring Security Filter
      ↓
Validate Token
      ↓
Access Protected APIs

---
# Expense Tracker Backend

A RESTful backend application built using Spring Boot and PostgreSQL for managing income and expense transactions with secure JWT-based authentication.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

## ✨ Features

### Authentication & Authorization

- User Registration
- User Login
- JWT Token Generation
- Protected APIs using Spring Security
- Stateless Authentication

### Transaction Management

- Add income and expenses
- Update transactions
- Delete transactions
- View transaction history
- Category-wise tracking

### Backend Architecture

- RESTful APIs
- Layered Architecture
- Exception Handling
- JPA Repository Pattern

---

## 📂 Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util

---

## 🔐 Authentication APIs

### Register User

POST

/api/auth/register

Request Body

```json
{
  "name": "Anjali",
  "email": "anjali@gmail.com",
  "password": "password123"
}
```

### Login User

POST

/api/auth/login

Request Body

```json
{
  "email": "anjali@gmail.com",
  "password": "password123"
}
```

Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

## 📌 Transaction APIs

| Method | Endpoint |
|----------|----------|
| GET | /api/transactions |
| GET | /api/transactions/{id} |
| POST | /api/transactions |
| PUT | /api/transactions/{id} |
| DELETE | /api/transactions/{id} |

---

## 🗄 Database

PostgreSQL

Tables:

- users
- transactions

---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/your-username/expense-tracker-backend.git
```

### Configure application.properties

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=
jwt.expiration=
```

### Run

```bash
mvn spring-boot:run
```

Server starts at:

http://localhost:8080

---

## 🏗 Architecture

React Frontend
      ↓
Axios
      ↓
JWT Token
      ↓
Spring Security Filter
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
PostgreSQL Database

---

## 🔒 Security Flow

User Login
      ↓
JWT Token Generated
      ↓
Frontend Stores Token
      ↓
Authorization Header

Bearer <token>

      ↓
Spring Security Filter
      ↓
Validate Token
      ↓
Access Protected APIs

---

## 📈 Future Enhancements

- Docker Support
- Unit Testing using JUnit & Mockito
- CI/CD using GitHub Actions

---

## 👩‍💻 Author

Anjali Khilari

Java Full Stack Developer

---





