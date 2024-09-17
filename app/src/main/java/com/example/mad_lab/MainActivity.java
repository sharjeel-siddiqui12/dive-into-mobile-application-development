package com.example.mad_lab;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewName);
        textView.setText("Muhammad Sharjeel Siddiqui");
        textView.setTextColor(ContextCompat.getColor(this, R.color.teal_700)); // Use ContextCompat.getColor
    }
}