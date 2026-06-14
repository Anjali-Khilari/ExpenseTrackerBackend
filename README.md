# Expense Tracker App

# Expense Tracker Backend

A RESTful backend application developed using Spring Boot and PostgreSQL for managing income and expense transactions.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

## 📌 Features

- Add new transactions
- View all transactions
- Update transaction details
- Delete transactions
- Category-wise expense tracking
- RESTful APIs
- PostgreSQL database integration
- Layered architecture (Controller → Service → Repository)

---

## 📂 Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config

---

## ⚙️ API Endpoints

### Get All Transactions

GET

/api/transactions

### Get Transaction by ID

GET

/api/transactions/{id}

### Add Transaction

POST

/api/transactions

### Update Transaction

PUT

/api/transactions/{id}

### Delete Transaction

DELETE

/api/transactions/{id}

---

## 🗄 Database

Database: PostgreSQL

Main Table:

### transactions

| Column Name | Type |
|-------------|------|
| id | Long |
| title | String |
| amount | Double |
| category | String |
| type | String |
| date | LocalDate |

---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/anjali-khilari/expense-tracker-backend.git
```

### Move into Project

```bash
cd expense-tracker-backend
```

### Configure application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/expense_tracker
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Start Application

```bash
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8080
```

---

## 🏗 Architecture

Frontend (React)
        ↓
Axios
        ↓
REST APIs
        ↓
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
PostgreSQL Database

---

## 👩‍💻 Author

Anjali Khilari

Java Full Stack Developer




