package com.diligent.expense_tracker.service;

import com.diligent.expense_tracker.model.Expense;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseServiceTest {

    @Test
    void testExpenseObject() {

        Expense expense = new Expense(
                1L,
                "Groceries",
                500.0,
                "Food",
                LocalDate.of(2026, 8, 1)
        );

        assertEquals(1L, expense.getId());
        assertEquals("Groceries", expense.getTitle());
        assertEquals(500.0, expense.getAmount());
        assertEquals("Food", expense.getCategory());
        assertEquals(LocalDate.of(2026, 8, 1), expense.getDate());
    }
}