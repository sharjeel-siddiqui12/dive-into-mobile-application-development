package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class L5exercise2_Order extends AppCompatActivity {

    EditText appleQtyEditText, bananaQtyEditText, avocadoQtyEditText;
    Button submitOrderButton;
    TextView customerNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5exercise2_order);

        customerNameTextView = findViewById(R.id.customerName);
        appleQtyEditText = findViewById(R.id.appleQty);
        bananaQtyEditText = findViewById(R.id.bananaQty);
        avocadoQtyEditText = findViewById(R.id.avocadoQty);
        submitOrderButton = findViewById(R.id.btnSubmitOrder);

        // Get username from intent
        String username = getIntent().getStringExtra("USERNAME");
        customerNameTextView.setText("Welcome, " + username);

        submitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capture the quantity of products
                String appleQty = appleQtyEditText.getText().toString();
                String bananaQty = bananaQtyEditText.getText().toString();
                String avocadoQty = avocadoQtyEditText.getText().toString();

                // Send data to SummaryActivity
                Intent intent = new Intent(L5exercise2_Order.this, L5exercise2_Summary.class);
                intent.putExtra("APPLE_QTY", appleQty);
                intent.putExtra("BANANA_QTY", bananaQty);
                intent.putExtra("AVOCADO_QTY", avocadoQty);
                startActivity(intent);
            }
        });
    }
}