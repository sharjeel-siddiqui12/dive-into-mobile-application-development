package com.example.lab8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;


public class L8exercise1 extends AppCompatActivity {

    private EditText empNameEditText, salaryEditText, joiningDateEditText, educationEditText, experienceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8exercise1);

        // Initialize the DatabaseHelper
        DatabaseHelper db = new DatabaseHelper(this);

        // Initialize EditTexts
        empNameEditText = findViewById(R.id.empNameEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        joiningDateEditText = findViewById(R.id.joiningDateEditText);
        educationEditText = findViewById(R.id.educationEditText);
        experienceEditText = findViewById(R.id.experienceEditText);

        // Set up the Add Button
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from the input fields
                String empName = empNameEditText.getText().toString();
                String salaryStr = salaryEditText.getText().toString();
                String joiningDate = joiningDateEditText.getText().toString();
                String education = educationEditText.getText().toString();
                String experienceStr = experienceEditText.getText().toString();

                // Validate inputs
                if (empName.isEmpty() || salaryStr.isEmpty() || joiningDate.isEmpty() ||
                        education.isEmpty() || experienceStr.isEmpty()) {
                    Toast.makeText(L8exercise1.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int salary = Integer.parseInt(salaryStr);
                int experience = Integer.parseInt(experienceStr);

                // Validate and format the joining date
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                inputFormat.setLenient(false); // Ensures strict date parsing
                try {
                    Date date = inputFormat.parse(joiningDate); // Parse to ensure correct format
                    joiningDate = inputFormat.format(date); // Format to DD-MM-YYYY again to standardize
                } catch (Exception e) {
                    Toast.makeText(L8exercise1.this, "Invalid date format. Use DD-MM-YYYY.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create an Employer instance
                Employer employer = new Employer(empName, salary, joiningDate, education, experience);

                // Insert the Employer instance into the database
                db.insertEmployer(employer);

                // Log insertion attempt
                Log.d("MainActivity", "Employee added successfully: " + empName);

                // Show confirmation message
                Toast.makeText(L8exercise1.this, "Employee added successfully", Toast.LENGTH_SHORT).show();

                // Clear input fields
                empNameEditText.setText("");
                salaryEditText.setText("");
                joiningDateEditText.setText("");
                educationEditText.setText("");
                experienceEditText.setText("");
            }
        });
    }


}