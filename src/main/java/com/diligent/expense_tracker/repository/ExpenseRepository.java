package com.diligent.expense_tracker.repository;

import com.diligent.expense_tracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();

    public void save(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> findAll() {
        return expenses;
    }

    public void deleteById(Long id) {
        expenses.removeIf(expense -> expense.getId().equals(id));
    }
}