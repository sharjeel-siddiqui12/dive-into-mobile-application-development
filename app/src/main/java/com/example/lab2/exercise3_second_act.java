package com.example.lab2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;

public class exercise3_second_act extends AppCompatActivity {

    private RelativeLayout layout;
    private Button buttonShowToast, buttonChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3_second);

        // Initialize views
        layout = findViewById(R.id.layout);
        buttonShowToast = findViewById(R.id.buttonShowToast);
        buttonChangeColor = findViewById(R.id.buttonChangeColor);

        // Button to show toast
        buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(exercise3_second_act.this, "This is the first toast message!", Toast.LENGTH_SHORT).show();
            }
        });

        // Button to change background color and show another toast
        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.parseColor("#FFC107"));  // Change background to amber
                Toast.makeText(exercise3_second_act.this, "Background color changed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
