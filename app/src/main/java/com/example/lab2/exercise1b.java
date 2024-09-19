package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.view.View;
import android.widget.Button;


public class exercise1b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1b);

        // Set Lab Instructor's name
        TextView textViewInstructor = findViewById(R.id.textViewInstructor);
        textViewInstructor.setText(getString(R.string.l2e2_instructor_name));

        // Back Button
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        // Next Button (can be configured for further navigation)
        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example for future navigation (can be implemented to go to another activity)
            }
        });
    }
}