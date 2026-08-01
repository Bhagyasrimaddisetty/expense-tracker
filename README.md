# Smart Expense Tracker API

A lightweight REST API for tracking personal expenses — add them, filter
them by category, total them up, and delete them. Built as a take-home
assignment for the Diligent Software Engineering Apprenticeship.

No database, no config — clone it, run one command, and it's live.

## Features

- ✅ Add an expense (`id`, `title`, `amount`, `category`, `date`)
- ✅ View all expenses
- ✅ Filter expenses by category (case-insensitive — `"food"` matches `"Food"`)
- ✅ Total expenses overall
- ✅ Total expenses by category
- ✅ Delete an expense by id
- ✅ Interactive API docs via Swagger UI
- ✅ Request validation (rejects missing fields, blank strings, non-positive amounts)

## Tech Stack

| | |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.5.5 |
| Build tool | Maven |
| Storage | In-memory (no database — by design, see below) |
| Docs | springdoc-openapi / Swagger UI |
| Tests | JUnit 5 |

## Why in-memory storage?

The assignment explicitly didn't require a database, so this uses a simple
in-memory list behind a repository interface. That keeps the project
zero-setup (no connection strings, no Docker, no schema) while still
following a proper layered architecture — swapping in a real database later
would only mean changing the repository implementation, not the service or
controller.

## Project Structure

```
expense-tracker/
├── README.md
├── AI_NOTES.md
├── src/
│   ├── main/java/com/diligent/expense_tracker/
│   │   ├── controller/    # REST endpoints
│   │   ├── service/       # business logic
│   │   ├── repository/    # in-memory data access
│   │   └── model/         # Expense entity
│   └── test/java/...      # test suite (standard Maven location)
└── tests/                 # pointer to the Maven test suite above
```

This is a Maven project, so tests live under `src/test/java` — Maven's
required convention for `./mvnw test` to discover and run them. The
top-level `tests/` folder contains a short README pointing there.

## Getting Started

**Requirements:** Java 17+

```bash
git clone <repository-url>
cd expense-tracker
```

### Run the app

Linux/macOS
```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Windows
```bash
mvnw.cmd spring-boot:run
```

The server starts on **http://localhost:8080**.

### Run the tests

Linux/macOS
```bash
chmod +x mvnw
./mvnw test
```

Windows
```bash
mvnw.cmd test
```

### Explore the API interactively

Once the app is running, open:

**http://localhost:8080/swagger-ui/index.html**

## API Reference

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/expenses` | Add a new expense |
| `GET` | `/expenses` | Get all expenses |
| `GET` | `/expenses/category/{category}` | Filter expenses by category |
| `GET` | `/expenses/total` | Total of all expenses |
| `GET` | `/expenses/total/{category}` | Total for one category |
| `DELETE` | `/expenses/{id}` | Delete an expense by id |

### Try it with curl

Add an expense:
```bash
curl -X POST http://localhost:8080/expenses \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "title": "Groceries",
    "amount": 500,
    "category": "Food",
    "date": "2026-08-01"
  }'
```

Get everything:
```bash
curl http://localhost:8080/expenses
```

Filter by category:
```bash
curl http://localhost:8080/expenses/category/Food
```

Total spend:
```bash
curl http://localhost:8080/expenses/total
```

Total for one category:
```bash
curl http://localhost:8080/expenses/total/Food
```

Delete an expense:
```bash
curl -X DELETE http://localhost:8080/expenses/1
```

## Design notes

- **Layered architecture** — controller → service → repository, so storage
  can be swapped without touching business logic or API contracts.
- **Validation** — `Expense` fields are annotated with `@NotBlank`,
  `@NotNull`, and `@Positive` so bad input (missing title, negative amount,
  etc.) is rejected at the controller boundary rather than silently accepted.
- **Case-insensitive category matching** — filtering and totals by category
  use `equalsIgnoreCase`, so users don't need to match exact casing.
