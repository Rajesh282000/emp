package com.employee_backend.emp.dto;



public class EmpDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dept;

    public EmpDto(String firstName, String dept, String lastName, String email, String password) {
        this.firstName = firstName;
        this.dept = dept;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public EmpDto(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }



}
