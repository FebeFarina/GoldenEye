package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private String generateEmail(Employee employee) {

        String[] name = employee.getName().toLowerCase().split(" ");
        String firstLetterName = name[0].substring(0, 1);
        String surName = name[1];

        return firstLetterName + surName + "." + employee.getDepartment() + "@"
                + employee.getOffice() + ".goldeneye.com";
    }

    private Boolean isValidDepartment(Employee employee) {
        switch (employee.getOffice()) {
            case "milan":
                return employee.getDepartment().equals("design") ||
                        employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
            case "spain":
                return employee.getDepartment().equals("research&development") ||
                        employee.getDepartment().equals("business");
            case "newyork":
                return employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
        }

        return false;
    }

    @GetMapping("/email")
    public String emailForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/email")
    public String submitForm(@ModelAttribute("employee") Employee employee, Model model) {

        String email = generateEmail(employee);
        model.addAttribute("email", email);

        return isValidDepartment(employee) ? "result" : "invalidForm";

    }
}