# Smart Expense Tracker API

A REST API built using Java and Spring Boot to manage personal expenses.

## Features

- Add an expense
- View all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate total expenses by category
- Delete an expense

## Technologies

- Java 17
- Spring Boot 3.5.5
- Maven
- Swagger/OpenAPI

## Project Structure

```
expense-tracker/
│── README.md
│── AI_NOTES.md
│── src/
│── tests/
```

## Installation

```bash
git clone <repository-url>
cd expense-tracker
```

## Run the Application

Windows

```bash
mvnw.cmd spring-boot:run
```

Linux/macOS

```bash
./mvnw spring-boot:run
```

## Run Tests

Windows

```bash
mvnw.cmd test
```

Linux/macOS

```bash
./mvnw test
```

## Swagger

```
http://localhost:8080/swagger-ui/index.html
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /expenses | Add Expense |
| GET | /expenses | Get All Expenses |
| GET | /expenses/category/{category} | Filter by Category |
| GET | /expenses/total | Total Expenses |
| GET | /expenses/total/{category} | Total by Category |
| DELETE | /expenses/{id} | Delete Expense |