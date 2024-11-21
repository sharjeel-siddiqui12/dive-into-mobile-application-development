package com.example.lab9;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.mad_lab.R;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class L9exercise1 extends AppCompatActivity {

    private EditText courseNameEditText, courseDurationEditText, courseTracksEditText, courseDescriptionEditText, searchCourseIdEditText;
    private Button addCourseButton, searchButton, updateButton, deleteButton;
    private ListView courseListView;

    private dbConnector db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9exercise1);

        // Initialize UI Components
        courseNameEditText = findViewById(R.id.courseNameEditText);
        courseDurationEditText = findViewById(R.id.courseDurationEditText);
        courseTracksEditText = findViewById(R.id.courseTracksEditText);
        courseDescriptionEditText = findViewById(R.id.courseDescriptionEditText);
        searchCourseIdEditText = findViewById(R.id.searchCourseIdEditText);

        addCourseButton = findViewById(R.id.addCourseButton);
        searchButton = findViewById(R.id.searchButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        courseListView = findViewById(R.id.courseListView);

        // Initialize Database Helper
        db = new dbConnector(this);

        // Display Existing Courses
        displayCourses();

        // Add Course Button
        addCourseButton.setOnClickListener(v -> {
            String name = courseNameEditText.getText().toString();
            String duration = courseDurationEditText.getText().toString();
            String tracks = courseTracksEditText.getText().toString();
            String description = courseDescriptionEditText.getText().toString();

            if (name.isEmpty() || duration.isEmpty() || tracks.isEmpty() || description.isEmpty()) {
                Toast.makeText(L9exercise1.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean success = db.insertCourse(name, duration, tracks, description);
            if (success) {
                Toast.makeText(L9exercise1.this, "Course added successfully", Toast.LENGTH_SHORT).show();
                displayCourses();
                clearFields();
            } else {
                Toast.makeText(L9exercise1.this, "Failed to add course", Toast.LENGTH_SHORT).show();
            }
        });

        // Search Course Button
        searchButton.setOnClickListener(v -> {
            String idStr = searchCourseIdEditText.getText().toString();
            if (idStr.isEmpty()) {
                Toast.makeText(L9exercise1.this, "Please enter a Course ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);
            Course course = db.getCourseById(id);
            if (course != null) {
                courseNameEditText.setText(course.getName());
                courseDurationEditText.setText(course.getDuration());
                courseTracksEditText.setText(course.getTracks());
                courseDescriptionEditText.setText(course.getDescription());
            } else {
                Toast.makeText(L9exercise1.this, "Course not found", Toast.LENGTH_SHORT).show();
            }
        });

        // Update Course Button
        updateButton.setOnClickListener(v -> {
            String idStr = searchCourseIdEditText.getText().toString();
            if (idStr.isEmpty()) {
                Toast.makeText(L9exercise1.this, "Please enter a Course ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);
            String name = courseNameEditText.getText().toString();
            String duration = courseDurationEditText.getText().toString();
            String tracks = courseTracksEditText.getText().toString();
            String description = courseDescriptionEditText.getText().toString();

            boolean success = db.updateCourse(id, name, duration, tracks, description);
            if (success) {
                Toast.makeText(L9exercise1.this, "Course updated successfully", Toast.LENGTH_SHORT).show();
                displayCourses();
                clearFields();
            } else {
                Toast.makeText(L9exercise1.this, "Failed to update course", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete Course Button
        deleteButton.setOnClickListener(v -> {
            String idStr = searchCourseIdEditText.getText().toString();
            if (idStr.isEmpty()) {
                Toast.makeText(L9exercise1.this, "Please enter a Course ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);
            boolean success = db.deleteCourse(id);
            if (success) {
                Toast.makeText(L9exercise1.this, "Course deleted successfully", Toast.LENGTH_SHORT).show();
                displayCourses();
                clearFields();
            } else {
                Toast.makeText(L9exercise1.this, "Failed to delete course", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayCourses() {
        ArrayList<Course> courses = db.getAllCourses();
        ArrayList<String> courseDetails = new ArrayList<>();
        for (Course course : courses) {
            courseDetails.add("ID: " + course.getId() +
                    "\nName: " + course.getName() +
                    "\nDuration: " + course.getDuration() +
                    "\nTracks: " + course.getTracks() +
                    "\nDescription: " + course.getDescription());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseDetails);
        courseListView.setAdapter(adapter);
    }

    private void clearFields() {
        courseNameEditText.setText("");
        courseDurationEditText.setText("");
        courseTracksEditText.setText("");
        courseDescriptionEditText.setText("");
        searchCourseIdEditText.setText("");
    }
}