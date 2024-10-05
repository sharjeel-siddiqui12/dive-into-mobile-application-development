package com.example.lab4;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.widget.TextView;


public class L4exercise1Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4exercise1);

        TextView textView = new TextView(this);
        textView.setText(getString(R.string.message));
        setContentView(textView);
    }
}