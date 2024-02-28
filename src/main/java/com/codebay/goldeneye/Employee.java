package com.codebay.goldeneye;

/**
 * Employee class
 * 
 * @author Febe Fariña Aguirre
 * @version 1.0
 */
public class Employee {

  private String firstName;
  private String surname;
  private String department;
  private String office;

  /**
   * Getter for the first name
   * 
   * @return String first name
   */

  public String getFirstName() {
    return firstName;
  }

  /**
   * Setter for the first name
   * 
   * @param firstName String first name
   */

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Getter for the surname
   * 
   * @return String surname
   */
  public String getSurname() {
    return surname;
  }

  /**
   * Setter for the surname
   * 
   * @param surname String surname
   */

  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Getter for the department
   * 
   * @return String department
   */

  public String getDepartment() {
    return department;
  }

  /**
   * Setter for the department
   * 
   * @param department String department
   */

  public void setDepartment(String department) {
    this.department = department;
  }

  /**
   * Getter for the office
   * 
   * @return String office
   */

  public String getOffice() {
    return office;
  }

  /**
   * Setter for the office
   * 
   * @param office String office
   */

  public void setOffice(String office) {
    this.office = office;
  }

  /**
   * toString method
   * 
   * @return String with the employee's information
   */
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
