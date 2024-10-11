package com.example.lab4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class L4exercise1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4exercise1);

        Button button = findViewById(R.id.buttonGoToNewActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(L4exercise1.this, L4exercise1Display.class);
                startActivity(intent);
            }
        });
    }
}