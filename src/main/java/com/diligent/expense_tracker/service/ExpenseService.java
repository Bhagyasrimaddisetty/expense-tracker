package com.diligent.expense_tracker.service;

import com.diligent.expense_tracker.model.Expense;
import com.diligent.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(Expense expense) {
        repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return repository.findAll()
                .stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double getTotalExpenses() {
        return repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getTotalByCategory(String category) {
        return repository.findAll()
                .stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}