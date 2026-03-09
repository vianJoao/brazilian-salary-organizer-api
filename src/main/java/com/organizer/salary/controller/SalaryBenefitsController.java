package com.organizer.salary.controller;

import com.organizer.salary.dto.SalaryBenefits;
import com.organizer.salary.dto.SalaryBenefitsResponse;
import com.organizer.salary.service.SalaryBenefitsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/benefits")
public class SalaryBenefitsController {

    private final SalaryBenefitsService salaryBenefitsService;

    public SalaryBenefitsController(SalaryBenefitsService salaryBenefitsService) {
        this.salaryBenefitsService = salaryBenefitsService;
    }

    @PostMapping("/simulate")
    public SalaryBenefitsResponse simulate(@RequestBody SalaryBenefits request) {
        return salaryBenefitsService.simulate(request);
    }
}