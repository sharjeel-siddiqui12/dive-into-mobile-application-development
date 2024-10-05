package com.example.lab4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class L4exercise4 extends AppCompatActivity {

    private EditText editTextName;
    private TextView textViewMessage;
    private Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4exercise4);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonOK = findViewById(R.id.buttonOK);

        // Set onClickListener for the button
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered name from EditText
                String name = editTextName.getText().toString().trim();

                // Check if the name is not empty
                if (!name.isEmpty()) {
                    // Display the hello message with the entered name
                    textViewMessage.setText("Hello, " + name + "!");
                } else {
                    // Display a default message if name is empty
                    textViewMessage.setText("Hello, Stranger!");
                }
            }
        });
    }
}