package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.widget.TextView;

public class L5exercise2_Summary extends AppCompatActivity {

    TextView summaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5exercise2_summary);

        summaryTextView = findViewById(R.id.orderSummary);

        // Get order data from intent
        String appleQty = getIntent().getStringExtra("APPLE_QTY");
        String bananaQty = getIntent().getStringExtra("BANANA_QTY");
        String avocadoQty = getIntent().getStringExtra("AVOCADO_QTY");

        // Create summary text
        String summary = "Order Summary:\n\n" +
                "Apple: " + appleQty + " kg\n" +
                "Banana: " + bananaQty + " kg\n" +
                "Avocado: " + avocadoQty + " kg";

        summaryTextView.setText(summary);
    }
}