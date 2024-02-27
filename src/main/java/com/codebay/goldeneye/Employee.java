package com.codebay.goldeneye;

import javax.validation.constraints.Pattern;


// This class represents an employee
public class Employee {

  @Pattern(regexp="[A-ZÀ-ÿ][-,a-z. ']*", message="Name can only contain letters")
  private String firstName;
  @Pattern(regexp="[A-ZÀ-ÿ][-,a-z. ']*", message="Name can only contain letters")
  private String surname;
  private String department;
  private String office;

  // Getters and setters

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  // toString method for debugging
  @Override
  public String toString() {
    return "Employee{" +
        "first name='" + firstName + '\'' +
        ", surname='" + surname + '\'' +
        ", department='" + department + '\'' +
        ", office='" + office + '\'' +
        '}';
  }

}
