package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class WebController {

    // This method generates the email for the employee
    private String generateEmail(Employee employee) {

        String firstLetterName = employee.getFirstName().substring(0, 1).toLowerCase();

        String[] surnameSplit = employee.getSurname().split(" ");
        String surname = surnameSplit[0].toLowerCase();

        return firstLetterName + surname + "." + employee.getDepartment() + "@"
                + employee.getOffice() + ".goldeneye.com";
    }

    // This method checks if the name is valid
    private Boolean isValidName(Employee employee) {
        return employee.getFirstName().length() > 0 && employee.getSurname().length() > 0;
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

    // Default endpoint
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

    // When the user submits the form, the email is generated and the department and
    // name are checked
    @PostMapping("/email")
    public String submitForm(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
            return "invalidForm";
        }

        String email = generateEmail(employee);
        model.addAttribute("email", email);

        return "result";

    }
}