package com.mahathii.expense_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahathii.expense_tracker.model.Expense;
import com.mahathii.expense_tracker.repository.ExpenseRepository;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

   @GetMapping("/")
public String home(Model model) {

    List<Expense> expenses = repository.findAll();

    double total = expenses.stream()
            .mapToDouble(Expense::getAmount)
            .sum();

    model.addAttribute("expenses", expenses);
    model.addAttribute("total", total);

    return "index";
}

    @PostMapping("/save")
    public String saveExpense(Expense expense) {

        repository.save(expense);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/";
    }
}