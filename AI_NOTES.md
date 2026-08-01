# AI Usage Notes

## 1. What was AI-generated vs. written by me

AI-generated (ChatGPT), then reviewed and edited by me:
- Initial Spring Boot project skeleton (folder layout, `pom.xml` dependencies)
- First draft of `Expense` model, `ExpenseRepository`, `ExpenseService`, and
  `ExpenseController`
- Swagger/OpenAPI dependency setup
- First-draft unit test scaffolding in `ExpenseServiceTest.java`

Written / decided by me:
- [FILL IN: e.g. "Rewrote the `addExpense` endpoint body — the AI's first
  version didn't return a clear response, I changed it to return a confirmation
  message and wired in `@Valid` for request validation."]
- [FILL IN: any endpoint logic, validation rule, or test case you wrote or
  meaningfully rewrote yourself rather than accepting as-is]
- Choice to keep data in-memory (`ArrayList`/repository pattern) instead of a
  database, per the assignment's explicit instructions

## 2. What I validated, tested, or changed, and why

- Ran the app locally and exercised every endpoint (add, get all, filter by
  category, total, total by category, delete) through Swagger UI at
  `/swagger-ui/index.html` to confirm request/response shapes matched the
  assignment spec (id, title, amount, category, date).
- Added `@NotNull`/`@NotBlank`/`@Positive` validation on the `Expense` model
  so invalid input (missing fields, negative amounts) is rejected with a
  clear error instead of silently accepted — this wasn't fully fleshed out in
  the AI's first draft.
- Fixed compilation and package-naming issues introduced when adapting the
  AI's generated code to this project's actual package structure
  (`com.diligent.expense_tracker`).
- Ran `./mvnw test` to confirm the full suite passes before submission.
- [FILL IN: any specific bug the AI's code had that you caught and fixed —
  e.g. wrong HTTP status code, category filter being case-sensitive when it
  shouldn't be, total calculation not handling an empty list, etc., if
  applicable]

## 3. AI suggestions I decided not to use, and why

- The AI initially suggested using a database (MySQL/H2) with Spring Data
  JPA. I kept an in-memory data structure instead, since the
  assignment explicitly said a database was not required and in-memory
  storage was simpler to review and run with zero setup.
- [FILL IN: any other suggestion you rejected — e.g. a bonus feature the AI
  pushed for that you skipped, a different framework/library it suggested, an
  over-engineered pattern (e.g. adding a full DTO layer) you decided was
  unnecessary for a 4-hour assignment]