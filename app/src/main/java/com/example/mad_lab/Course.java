package com.example.mad_lab;

public class Course {
    private int id;
    private String courseName;
    private String courseCode;
    private String instructor;

    public Course(int id, String courseName, String courseCode, String instructor) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getInstructor() {
        return instructor;
    }
}
