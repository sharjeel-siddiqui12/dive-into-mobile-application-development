package com.example.mad_lab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set your name in the TextView
        TextView textView = findViewById(R.id.textViewName);
        textView.setText(getString(R.string.my_name));
    }
}
