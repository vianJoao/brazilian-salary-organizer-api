package com.organizer.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryBenefitsResponse {

    private double realMonthlyIncome;
    private double totalExpenses;
    private double remainingMoney;
    private double financialMargin;
    private String status;
}