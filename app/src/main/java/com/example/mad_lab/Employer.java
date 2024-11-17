package com.example.mad_lab;


import java.util.UUID;

public class Employer {
    private String empid;
    private String emp_name;
    private double salary;
    private String joining_date;
    private String education;
    private int experience;

    public Employer(String emp_name, double salary, String joining_date, String education, int experience) {
        this.empid = UUID.randomUUID().toString();
        this.emp_name = emp_name;
        this.salary = salary;
        this.joining_date = joining_date;
        this.education = education;
        this.experience = experience;
    }

    public String getEmpid() {
        return empid;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public double getSalary() {
        return salary;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public String getEducation() {
        return education;
    }

    public int getExperience() {
        return experience;
    }
}
