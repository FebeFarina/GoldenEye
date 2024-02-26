package com.codebay.goldeneye;

public class Employee {

  private String name;
  private String department;
  private String office;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", office='" + office + '\'' +
        '}';
  }

}
