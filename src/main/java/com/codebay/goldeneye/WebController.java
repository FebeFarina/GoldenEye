package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    // This method generates the email for the employee
    private String generateEmail(Employee employee) {

        /*
         * To separate the first name and surname, we split the name by space.
         * Then, we take the first letter of the first name and the surname.
         */
        String[] name = employee.getName().toLowerCase().split(" ");
        String firstLetterName = name[0].substring(0, 1);
        String surName = name[1];

        return firstLetterName + surName + "." + employee.getDepartment() + "@"
                + employee.getOffice() + ".goldeneye.com";
    }

    // This method checks if the department is valid for the office
    private Boolean isValidDepartment(Employee employee) {
        switch (employee.getOffice()) {
            /*
             * Milan office can have employees from design, business and advertising
             * departments
             */
            case "milan":
                return employee.getDepartment().equals("design") ||
                        employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
            // Spain office can have employees from research&development and business
            case "spain":
                return employee.getDepartment().equals("research&development") ||
                        employee.getDepartment().equals("business");
            // New York office can have employees from business and advertising departments
            case "newyork":
                return employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
        }

        return false;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // When the user accesses the /email endpoint, a new Employee object is created
    @GetMapping("/email")
    public String emailForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "email";
    }

    // When the user submits the form, the email is generated and the department is
    // checked
    @PostMapping("/email")
    public String submitForm(@ModelAttribute("employee") Employee employee, Model model) {

        String email = generateEmail(employee);
        model.addAttribute("email", email);

        return isValidDepartment(employee) ? "result" : "invalidForm";

    }
}