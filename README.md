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
│   │── main/java/...      # application source
│   └── test/java/...      # test suite (standard Maven location)
│── tests/                 # pointer to the Maven test suite above
```

This is a Maven project, so tests live under `src/test/java` (Maven's
required convention for `./mvnw test` to discover them). The top-level
`tests/` folder contains a short README pointing to them.

## Installation

Requires Java 17+ installed.

```bash
git clone <repository-url>
cd expense-tracker
```

## Run the Application

Linux/macOS

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Windows

```bash
mvnw.cmd spring-boot:run
```

The server starts on `http://localhost:8080`.

## Run Tests

Linux/macOS

```bash
chmod +x mvnw
./mvnw test
```

Windows

```bash
mvnw.cmd test
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