package com.organizer.salary.service;

import com.organizer.salary.dto.SalaryBenefits;
import com.organizer.salary.dto.SalaryBenefitsResponse;
import org.springframework.stereotype.Service;

@Service
public class SalaryBenefitsService {

    public SalaryBenefitsResponse simulate(SalaryBenefits request) {

        double income = request.getSalary();

        if ("PJ".equalsIgnoreCase(request.getContractTypes())) {
            income = calculatePJIncome(request);
        } else if ("CLT".equalsIgnoreCase(request.getContractTypes())) {
            income = calculateCLTIncome(request);
        }

        double foodExpense = request.isHasFoodVoucher()
                ? Math.max(0, request.getFoodExpense() - request.getFoodVoucher())
                : request.getFoodExpense();

        double totalExpenses =
                request.getCardExpense() +
                request.getFixedExpenses() +
                foodExpense;

        double remaining = income - totalExpenses;

        double margin = income == 0 ? 0 : remaining / income;

        String status;

        if (margin < 0) {
            status = "Deficit";
        } else if (margin < 0.1) {
            status = "Orçamento apertado";
        } else if (margin < 0.3) {
            status = "Equilibrado";
        } else {
            status = "Boa capacidade de investimento";
        }

        return new SalaryBenefitsResponse(
                income,
                totalExpenses,
                remaining,
                margin,
                status
        );
    }

    private double calculatePJIncome(SalaryBenefits request) {

        double income = request.getSalary();

        double tax = income * request.getTaxRate();
        income = income - tax - request.getAccountantCost();

        return income;
    }

    private double calculateCLTIncome(SalaryBenefits request) {

        double salary = request.getSalary();

        // INSS simplificado (apenas exemplo didático)
        double inss = salary * 0.11;

        double baseAfterInss = salary - inss;

        // IRRF simplificado
        double irrf = baseAfterInss * 0.15;

        return baseAfterInss - irrf;
    }
}