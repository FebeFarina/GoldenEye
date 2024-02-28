package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * WebController class
 * 
 * This class is the controller for the web application
 * 
 */
@Controller
public class WebController {

    /**
     * 
     * This method generates the email for the employee based on the following
     * [F][SURN].[DEPT]@[OFFICE].goldeneye.com
     * 
     * - [F] is the first letter of the first name
     * - [SURN] is the surname
     * - [DEPT] is the department
     * - [OFFICE] is the office
     * 
     * 
     * @param employee The employee object
     * @return String The email
     */
    private String generateEmail(Employee employee) {

        String firstLetterName = employee.getFirstName().substring(0, 1).toLowerCase();

        String[] surnameSplit = employee.getSurname().split(" ");
        String surname = surnameSplit[0].toLowerCase();

        return firstLetterName + surname + "." + employee.getDepartment() + "@"
                + employee.getOffice() + ".goldeneye.com";
    }

    /**
     * This method checks if the name is valid. It should contain only letters and a
     * minimum of 2 characters
     * 
     * @param employee The employee object
     * @return Boolean True if the name is valid, false otherwise
     */

    private Boolean isValidName(Employee employee) {
        return employee.getFirstName().matches("[A-Za-z ]{2,}") &&
                employee.getSurname().matches("[A-Za-z ]{2,}");
    }

    /**
     * This method checks if the department is valid for the office. The valid
     * combinations are:
     * 
     * - milan: design, business, advertising
     * - spain: researchdevelopment, business
     * - newyork: business, advertising
     * 
     * @param employee The employee object
     * @return Boolean True if the department is valid, false otherwise
     */

    private Boolean isValidDepartment(Employee employee) {
        switch (employee.getOffice()) {
            case "milan":
                return employee.getDepartment().equals("design") ||
                        employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
            case "spain":
                return employee.getDepartment().equals("researchdevelopment") ||
                        employee.getDepartment().equals("business");
            case "newyork":
                return employee.getDepartment().equals("business") ||
                        employee.getDepartment().equals("advertising");
        }

        return false;
    }

    /**
     * This method returns the home page
     * 
     * @return String The home page
     */

    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * This method returns the email form
     * 
     * @param model The model
     * @return String The email form page
     */

    @GetMapping("/email")
    public String emailForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "email";
    }

    /**
     * This method submits the form. It checks if the name and department are valid
     * before generating the email
     * 
     * @param employee The employee object created
     * @param model    The model
     * @return String The result page
     */

    @PostMapping("/email")
    public String submitForm(@ModelAttribute("employee") Employee employee, Model model) {

        if (!isValidName(employee)) {
            model.addAttribute("error", "Invalid name");
            return "invalidForm";
        }

        if (!isValidDepartment(employee)) {
            model.addAttribute("error", "Invalid department for the office");
            return "invalidForm";
        }

        String email = generateEmail(employee);
        model.addAttribute("email", email);

        return "result";

    }
}