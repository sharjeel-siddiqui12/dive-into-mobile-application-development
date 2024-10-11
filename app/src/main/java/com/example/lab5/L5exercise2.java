package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class L5exercise2 extends AppCompatActivity {

    EditText nameEditText, phoneEditText, emailEditText;
    EditText appleQtyEditText, bananaQtyEditText, avocadoQtyEditText;
    Button submitButton;
    TextView orderSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5exercise2);

        // Customer Details
        nameEditText = findViewById(R.id.customerName);
        phoneEditText = findViewById(R.id.customerPhone);
        emailEditText = findViewById(R.id.customerEmail);

        // Product Quantities
        appleQtyEditText = findViewById(R.id.appleQty);
        bananaQtyEditText = findViewById(R.id.bananaQty);
        avocadoQtyEditText = findViewById(R.id.avocadoQty);

        // Submit Button and Order Summary
        submitButton = findViewById(R.id.submitButton);
        orderSummaryTextView = findViewById(R.id.orderSummary);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get customer details
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();

                // Get product quantities
                String appleQty = appleQtyEditText.getText().toString();
                String bananaQty = bananaQtyEditText.getText().toString();
                String avocadoQty = avocadoQtyEditText.getText().toString();

                // Check if all fields are filled
                if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || appleQty.isEmpty() || bananaQty.isEmpty() || avocadoQty.isEmpty()) {
                    Toast.makeText(L5exercise2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display order summary
                String orderSummary = "Customer Details:\n" +
                        "Name: " + name + "\n" +
                        "Phone: " + phone + "\n" +
                        "Email: " + email + "\n\n" +
                        "Order Details:\n" +
                        "Apples: " + appleQty + " kg\n" +
                        "Bananas: " + bananaQty + " dozen\n" +
                        "Avocados: " + avocadoQty + " kg";

                orderSummaryTextView.setText(orderSummary);

                int totalApples = Integer.parseInt(appleQty);
                int totalBananas = Integer.parseInt(bananaQty);
                int totalAvocados = Integer.parseInt(avocadoQty);
                int totalCost = (totalApples * 100) + (totalBananas * 120) + (totalAvocados * 130);
                orderSummaryTextView.append("\n\nTotal Cost: Rs. " + totalCost);

            }
        });
    }
}