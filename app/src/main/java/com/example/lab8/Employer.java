package com.example.lab8;

import java.util.Random;


public class Employer {
    private int empid;
    private String emp_name;
    private double salary;
    private String joining_date;
    private String education;
    private int experience;

    // Constructor
    public Employer(String emp_name, double salary, String joining_date, String education, int experience) {
        this.empid = generateEmpId();
        this.emp_name = emp_name;
        this.salary = salary;
        this.joining_date = joining_date;
        this.education = education;
        this.experience = experience;
    }

    // Getter methods
    public int getEmpId() {
        return empid;
    }

    public String getEmpName() {
        return emp_name;
    }

    public double getSalary() {
        return salary;
    }

    public String getJoiningDate() {
        return joining_date;
    }

    public String getEducation() {
        return education;
    }

    public int getExperience() {
        return experience;
    }

    // Method to generate a random empid
    private int generateEmpId() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // generates a random 6-digit empid
    }
}
