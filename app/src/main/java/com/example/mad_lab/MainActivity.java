package com.example.mad_lab;
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

public class MainActivity extends AppCompatActivity {

    private EditText etCourseName, etCourseCode, etInstructor;
    private Button btnAdd;
    private ListView lvCourses;
    private DBHandler dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCourseName = findViewById(R.id.et_courseName);
        etCourseCode = findViewById(R.id.et_courseCode);
        etInstructor = findViewById(R.id.et_instructor);
        btnAdd = findViewById(R.id.btn_add);
        lvCourses = findViewById(R.id.lv_courses);
        dbHelper = new DBHandler(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = etCourseName.getText().toString();
                String courseCode = etCourseCode.getText().toString();
                String instructor = etInstructor.getText().toString();

                if (dbHelper.insertCourse(courseName, courseCode, instructor)) {
                    Toast.makeText(MainActivity.this, "Course Added!", Toast.LENGTH_SHORT).show();
                    displayCourses();
                } else {
                    Toast.makeText(MainActivity.this, "Error Adding Course!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        displayCourses();
    }

    private void displayCourses() {
        ArrayList<Course> courses = dbHelper.getAllCourses();
        ArrayList<String> courseNames = new ArrayList<>();
        for (Course course : courses) {
            courseNames.add(course.getCourseName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseNames);
        lvCourses.setAdapter(adapter);
    }
}