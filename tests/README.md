# Tests

This is a Java/Spring Boot (Maven) project. Maven requires tests to live under
`src/test/java` for the build tool and IDEs to discover and run them
automatically — moving them into a separate top-level `tests/` folder would
break `./mvnw test`.

Test suite location: [`src/test/java/com/diligent/expense_tracker/`](../src/test/java/com/diligent/expense_tracker/)

- `service/ExpenseServiceTest.java` — unit tests for add, view, filter by
  category, total (overall + by category), and delete
- `ExpenseTrackerApplicationTests.java` — Spring context load test

Run all tests:

```bash
./mvnw test
```
