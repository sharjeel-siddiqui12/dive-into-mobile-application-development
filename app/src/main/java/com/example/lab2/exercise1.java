package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;
import com.example.mad_lab.R;
import androidx.appcompat.app.AppCompatActivity;


public class exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewName);
        textView.setText(getString(R.string.my_name));
    }
}