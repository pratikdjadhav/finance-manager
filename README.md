# 💰 Finance Manager REST API

A personal finance management REST API built with **Spring Boot**, **MySQL**, and **JPA/Hibernate**.
This project allows users to track their income and expenses, categorize transactions, and calculate their total balance.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3.x | Backend Framework |
| Spring Web | REST API |
| Spring Data JPA | Database ORM |
| Hibernate | JPA Implementation |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate Code |
| Maven | Build Tool |

---

## 📁 Project Structure

```
src/main/java/dev/pratik/financemanager/
├── controller/
│   └── TransactionController.java   # REST API endpoints
├── service/
│   └── TransactionService.java      # Business logic
├── repository/
│   └── TransactionRepository.java   # Database operations
├── model/
│   ├── Transaction.java             # Transaction entity
│   └── TransactionType.java         # INCOME/EXPENSE enum
└── FinanceManagerApplication.java   # Main class
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL 8+
- Maven

### Setup

1. **Clone the repository**
```bash
git clone https://github.com/pratikdjadhav/finance-manager.git
cd finance-manager
```

2. **Create MySQL database**
```sql
CREATE DATABASE finance_db;
```

3. **Configure database connection**

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password
```

4. **Run the application**
```bash
mvn spring-boot:run
```

App will start on `http://localhost:8080` 🚀

---

## 📡 API Endpoints

### Base URL: `http://localhost:8080/api/transactions`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/` | Add a new transaction |
| GET | `/` | Get all transactions |
| GET | `/type/{type}` | Get by type (INCOME/EXPENSE) |
| GET | `/category/{category}` | Get by category |
| GET | `/balance` | Get total balance |
| DELETE | `/{id}` | Delete a transaction |

---

## 📝 Sample API Usage

### Add a Transaction
```http
POST http://localhost:8080/api/transactions
Content-Type: application/json

{
    "title": "Monthly Salary",
    "amount": 50000,
    "type": "INCOME",
    "category": "Salary",
    "date": "2026-05-19",
    "note": "May month salary"
}
```

### Response
```json
{
    "id": 1,
    "title": "Monthly Salary",
    "amount": 50000.0,
    "type": "INCOME",
    "category": "Salary",
    "date": "2026-05-19",
    "note": "May month salary"
}
```

### Get Total Balance
```http
GET http://localhost:8080/api/transactions/balance
```
```json
50000.0
```

---

## 🔮 Upcoming Features

- [✔] JWT Authentication (Login/Register)
- [ ] User wise transactions
- [ ] Monthly reports
- [ ] Exception handling
- [ ] API documentation with Swagger

---

## 👨‍💻 Author

**Pratik Jadhav**
- GitHub: [@pratikdjadhav](https://github.com/pratikdjadhav)
- LinkedIn: [Pratik Jadhav](https://linkedin.com/in/jadhavpratikd)

---

⭐ If you found this project helpful, please give it a star!
    