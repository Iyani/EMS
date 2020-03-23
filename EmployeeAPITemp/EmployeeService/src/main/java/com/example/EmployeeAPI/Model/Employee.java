package com.example.EmployeeAPI.Model;

import javax.persistence.*;

@Entity
@Table(name="employee")

public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    @Column(name ="employeeName")
    private String employeeName;

    @Column(name ="employeeEmail")
    private String employeeEmail;

    @Column(name ="dateOfBirth")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth;

    @Column(name ="skills")
    private String skills;

    public Employee(){}

    public Employee(Long id, String employeeName, String employeeEmail, String dateOfBirth, String skills) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.dateOfBirth = dateOfBirth;
        this.skills = skills;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id +", employeeName=" + employeeName +
                ", employeeEmail=" + employeeEmail +
                ", dateOfBirth=" + dateOfBirth   + ", skills=" + skills   + "]";
    }

}
