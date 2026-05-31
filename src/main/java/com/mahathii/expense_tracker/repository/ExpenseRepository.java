package com.mahathii.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahathii.expense_tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}