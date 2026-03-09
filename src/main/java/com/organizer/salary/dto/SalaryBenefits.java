package com.organizer.salary.dto;

import lombok.Data;

@Data
public class SalaryBenefits {

    private String contractTypes; // CLT ou PJ

    private double salary;

    // Benefícios
    private boolean hasThirteenth;
    private boolean hasVacation;
    private boolean hasHealthInsurance;
    private boolean hasFoodVoucher;
    private double foodVoucher;

    // Despesas
    private double foodExpense;
    private double cardExpense;
    private double fixedExpenses;

    // PJ
    private double taxRate;
    private double accountantCost;
}