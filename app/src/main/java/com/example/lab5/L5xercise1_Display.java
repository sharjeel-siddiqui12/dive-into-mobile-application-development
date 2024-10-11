package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.widget.TextView;

public class L5xercise1_Display extends AppCompatActivity {

    TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5xercise1_display);

        textViewData = findViewById(R.id.textViewData);

        // Get the data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String data = "First Name: " + bundle.getString("firstName") + "\n"
                    + "Middle Name: " + bundle.getString("middleName") + "\n"
                    + "Last Name: " + bundle.getString("lastName") + "\n"
                    + "Course: " + bundle.getString("course") + "\n"
                    + "Gender: " + bundle.getString("gender") + "\n"
                    + "Phone: " + bundle.getString("phone") + "\n"
                    + "Address: " + bundle.getString("address") + "\n"
                    + "Email: " + bundle.getString("email");

            textViewData.setText(data);
        }
    }
}