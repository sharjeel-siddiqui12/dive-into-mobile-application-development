package com.example.lab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class exercise4 extends AppCompatActivity {

    private RadioGroup rgFirstChoice, rgSecondChoice, rgThirdChoice;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise4);

        rgFirstChoice = findViewById(R.id.rgFirstChoice);
        rgSecondChoice = findViewById(R.id.rgSecondChoice);
        rgThirdChoice = findViewById(R.id.rgThirdChoice);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if all choices are selected
                if (rgFirstChoice.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(exercise4.this, "Please select your first choice.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rgSecondChoice.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(exercise4.this, "Please select your second choice.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rgThirdChoice.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(exercise4.this, "Please select your third choice.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(exercise4.this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}