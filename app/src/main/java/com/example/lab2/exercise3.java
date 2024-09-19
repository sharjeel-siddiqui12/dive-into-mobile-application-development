package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_lab.R;

public class exercise3 extends AppCompatActivity {

    private Button buttonGoToSecondActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        buttonGoToSecondActivity = findViewById(R.id.buttonGoToSecondActivity);

        // Navigate to the second activity
        buttonGoToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercise3.this, exercise3_second_act.class);
                startActivity(intent);
            }
        });
    }
}
