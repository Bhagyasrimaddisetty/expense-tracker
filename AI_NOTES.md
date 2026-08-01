# AI Usage Notes

## 1. What was AI-generated vs. written by me

### AI-generated (ChatGPT), then reviewed and edited by me

- Initial Spring Boot project structure
- Initial implementation of the `Expense` model, `ExpenseRepository`, `ExpenseService`, and `ExpenseController`
- Swagger/OpenAPI configuration
- Initial unit test template
- README documentation template

### Written, modified, or decided by me

- Configured the project and resolved Maven build issues.
- Fixed package naming and import issues to match the project structure.
- Added validation using `@Valid`, `@NotNull`, `@NotBlank`, and `@Positive`.
- Tested and verified every API endpoint using Swagger UI.
- Chose to use in-memory storage (`ArrayList`) instead of a database because the assignment explicitly stated that no database was required.

---

## 2. What I validated, tested, or changed, and why

- Built and ran the project locally using Maven.
- Tested all REST endpoints using Swagger UI:
  - Add Expense
  - View All Expenses
  - Filter by Category
  - Calculate Total Expenses
  - Calculate Total by Category
  - Delete Expense
- Added validation to prevent invalid input such as empty titles, missing fields, and negative amounts.
- Fixed compilation errors caused by incorrect package names and project structure.
- Corrected project configuration and dependencies until the project built successfully.
- Executed the Maven test suite to verify the application builds successfully before submission.

---

## 3. AI suggestions I decided not to use, and why

- AI suggested using a database (MySQL/H2) with Spring Data JPA. I chose an in-memory data structure because the assignment explicitly stated that a database was not required.
- AI suggested adding additional features beyond the assignment requirements. I decided to focus on completing all required functionality and adding Swagger documentation instead of implementing extra features.
