package com.example.lab4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mad_lab.R;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class L4exercise2 extends AppCompatActivity {

    private TextView textView;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4exercise2);

        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioGroup);

        // Set up listener for the radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioRed) {
                    textView.setTextColor(Color.RED);
                } else if (checkedId == R.id.radioBlue) {
                    textView.setTextColor(Color.BLUE);
                } else if (checkedId == R.id.radioGreen) {
                    textView.setTextColor(Color.GREEN);
                }
            }
        });
    }
}