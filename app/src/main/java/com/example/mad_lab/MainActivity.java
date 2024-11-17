package com.example.mad_lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText empName, empSalary, empJoiningDate, empEducation, empExperience;
    private Button addEmployerBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empName = findViewById(R.id.empName);
        empSalary = findViewById(R.id.empSalary);
        empJoiningDate = findViewById(R.id.empJoiningDate);
        empEducation = findViewById(R.id.empEducation);
        empExperience = findViewById(R.id.empExperience);
        addEmployerBtn = findViewById(R.id.addEmployerBtn);
        dbHandler = new DBHandler(this);

        addEmployerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = empName.getText().toString();
                String salaryStr = empSalary.getText().toString();
                String joiningDate = empJoiningDate.getText().toString();
                String education = empEducation.getText().toString();
                String experienceStr = empExperience.getText().toString();

                if (name.isEmpty() || salaryStr.isEmpty() || joiningDate.isEmpty() ||
                        education.isEmpty() || experienceStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salary = Double.parseDouble(salaryStr);
                int experience = Integer.parseInt(experienceStr);

                Employer employer = new Employer(name, salary, joiningDate, education, experience);
                dbHandler.addEmployer(employer);

                Toast.makeText(MainActivity.this, "Employer Added Successfully!", Toast.LENGTH_SHORT).show();
                clearFields();
            }
        });
    }

    private void clearFields() {
        empName.setText("");
        empSalary.setText("");
        empJoiningDate.setText("");
        empEducation.setText("");
        empExperience.setText("");
    }
}