package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class L5exercise1 extends AppCompatActivity {

    EditText firstName, middleName, lastName, phoneNumber, address, email, password, retypePassword;
    Spinner courseSpinner;
    RadioGroup genderRadioGroup;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5exercise1);

        // Initialize views
        firstName = findViewById(R.id.firstName);
        middleName = findViewById(R.id.middleName);
        lastName = findViewById(R.id.lastName);
        courseSpinner = findViewById(R.id.courseSpinner);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        phoneNumber = findViewById(R.id.phoneNumber);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        retypePassword = findViewById(R.id.retypePassword);
        registerButton = findViewById(R.id.registerButton);

        // Set click listener on the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the data entered
                String fname = firstName.getText().toString();
                String mname = middleName.getText().toString();
                String lname = lastName.getText().toString();
                String course = courseSpinner.getSelectedItem().toString();
                String gender = ((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString();
                String phone = phoneNumber.getText().toString();
                String addr = address.getText().toString();
                String emailText = email.getText().toString();

                // Send data to second activity using intent
                Intent intent = new Intent(L5exercise1.this, L5xercise1_Display.class);
                intent.putExtra("firstName", fname);
                intent.putExtra("middleName", mname);
                intent.putExtra("lastName", lname);
                intent.putExtra("course", course);
                intent.putExtra("gender", gender);
                intent.putExtra("phone", phone);
                intent.putExtra("address", addr);
                intent.putExtra("email", emailText);
                startActivity(intent);
            }
        });
    }
}