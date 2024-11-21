package com.example.lab9;

public class Course {
    private int id; // Course ID
    private String name;
    private String duration;
    private String tracks;
    private String description;

    // Constructor
    public Course(int id, String name, String duration, String tracks, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.tracks = tracks;
        this.description = description;
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getTracks() {
        return tracks;
    }

    public String getDescription() {
        return description;
    }
}
