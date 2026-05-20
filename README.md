# 💰 Finance Manager REST API

A secure personal finance management REST API built with **Java**, **Spring Boot**, **MySQL**, and **JWT Authentication**.

🌐 **Live API:** https://finance-manager-production-be9e.up.railway.app  
📖 **Swagger Docs:** https://finance-manager-production-be9e.up.railway.app/swagger-ui/index.html  
💻 **GitHub:** https://github.com/pratikdjadhav/finance-manager

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
| Spring Security | Authentication & Authorization |
| JWT (jjwt 0.11.5) | Stateless Token Authentication |
| BCrypt | Password Encryption |
| Swagger / OpenAPI | API Documentation |
| Lombok | Reduce Boilerplate Code |
| Maven | Build Tool |
| Railway | Cloud Deployment |

---

## 📁 Project Structure

```
src/main/java/dev/pratik/financemanager/
├── auth/
│   ├── AuthController.java          # Register & Login APIs
│   ├── AuthRequest.java             # Login/Register request body
│   └── AuthResponse.java           # JWT token response body
├── controller/
│   └── TransactionController.java  # Transaction REST API endpoints
├── exception/
│   ├── ErrorResponse.java          # Standard error response structure
│   ├── GlobalExceptionHandler.java # Catches all exceptions globally
│   └── ResourceNotFoundException.java # Custom 404 exception
├── model/
│   ├── Transaction.java            # Transaction entity
│   └── TransactionType.java        # INCOME/EXPENSE enum
├── repository/
│   └── TransactionRepository.java  # Database operations
├── security/
│   ├── JwtAuthenticationFilter.java # Validates JWT on every request
│   ├── JwtUtil.java                # JWT generation & validation
│   ├── SecurityConfig.java         # Spring Security configuration
│   ├── SwaggerConfig.java          # Swagger/OpenAPI configuration
│   └── UserDetailsServiceImpl.java # Loads user for authentication
├── service/
│   └── TransactionService.java     # Business logic layer
└── FinanceManagerApplication.java  # Main class
```

---

## 🏗️ Architecture

```
HTTP Request
     ↓
JwtAuthenticationFilter  (validates JWT token)
     ↓
Controller               (receives request)
     ↓
Service                  (business logic)
     ↓
Repository               (database operation)
     ↓
MySQL Database
     ↓
Response flows back to user
```

---

## 🚀 Getting Started Locally

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

Create `src/main/resources/application.properties`:
```properties
spring.application.name=finance-manager
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8080
```

4. **Run the application**
```bash
mvn spring-boot:run
```

App will start on `http://localhost:8080` 🚀

---

## 📡 API Endpoints

### 🔓 Auth APIs (Public)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |

### 🔐 Transaction APIs (Protected — JWT Required)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/transactions` | Add a new transaction |
| GET | `/api/transactions` | Get all transactions |
| GET | `/api/transactions/{id}` | Get transaction by ID |
| PUT | `/api/transactions/{id}` | Update a transaction |
| DELETE | `/api/transactions/{id}` | Delete a transaction |
| GET | `/api/transactions/type/{type}` | Filter by INCOME or EXPENSE |
| GET | `/api/transactions/category/{category}` | Filter by category |
| GET | `/api/transactions/balance` | Get total balance |

---

## 📝 Sample API Usage

### 1. Register
```http
POST https://finance-manager-production-be9e.up.railway.app/api/auth/register
Content-Type: application/json

{
    "username": "pratik",
    "password": "123456"
}
```
Response:
```
User registered successfully!
```

### 2. Login
```http
POST https://finance-manager-production-be9e.up.railway.app/api/auth/login
Content-Type: application/json

{
    "username": "pratik",
    "password": "123456"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 3. Add Transaction (with JWT)
```http
POST https://finance-manager-production-be9e.up.railway.app/api/transactions
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
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

### 4. Get Total Balance (with JWT)
```http
GET https://finance-manager-production-be9e.up.railway.app/api/transactions/balance
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```
Response:
```json
450000.0
```

### 5. Error Response (invalid ID)
```http
GET https://finance-manager-production-be9e.up.railway.app/api/transactions/999
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```
Response:
```json
{
  "status": 404,
  "message": "Transaction with id 999 not found",
  "timestamp": "2026-05-19T13:02:55"
}
```

---

## 🔐 Security

- All transaction endpoints are protected with JWT authentication
- Passwords are encrypted using **BCrypt** hashing
- JWT tokens expire after **10 hours**
- Stateless authentication — no sessions stored on server
- Register and Login endpoints are publicly accessible

---

## 👨‍💻 Author

**Pratik Jadhav**
- GitHub: [@pratikdjadhav](https://github.com/pratikdjadhav)
- LinkedIn: [Pratik Jadhav](https://www.linkedin.com/in/jadhavpratikd/)

---

⭐ If you found this project helpful, please give it a star!
