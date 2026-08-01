package com.diligent.expense_tracker.controller;

import com.diligent.expense_tracker.model.Expense;
import com.diligent.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

   @PostMapping
public String addExpense(@jakarta.validation.Valid @RequestBody Expense expense) {
    service.addExpense(expense);
    return "Expense added successfully";
}

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category) {
        return service.getExpensesByCategory(category);
    }

    @GetMapping("/total")
    public double getTotalExpenses() {
        return service.getTotalExpenses();
    }

    @GetMapping("/total/{category}")
    public double getTotalByCategory(@PathVariable String category) {
        return service.getTotalByCategory(category);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "Expense deleted successfully";
    }
}