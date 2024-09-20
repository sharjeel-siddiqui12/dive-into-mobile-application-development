package com.example.lab2;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.mad_lab.R;
import androidx.appcompat.app.AppCompatActivity;


public class exercise5 extends AppCompatActivity {

    private Spinner quantitySpinner1, quantitySpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise5);

        quantitySpinner1 = findViewById(R.id.quantitySpinner1);
        quantitySpinner2 = findViewById(R.id.quantitySpinner2);
        Button orderButton = findViewById(R.id.orderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity1 = quantitySpinner1.getSelectedItem().toString();
                String quantity2 = quantitySpinner2.getSelectedItem().toString();

                Toast.makeText(exercise5.this,
                        "Ordered Bread: " + quantity1 + "\nOrdered Cake: " + quantity2,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}