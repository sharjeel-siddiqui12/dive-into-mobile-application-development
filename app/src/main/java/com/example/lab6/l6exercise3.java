package com.example.lab6;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;

public class l6exercise3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6exercise3);

        ListView listView = findViewById(R.id.listView);

        final String[] festivals = {
                "Diwali",
                "Holi",
                "Christmas",
                "Eid",
                "Baisakhi",
                "Halloween"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                festivals
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedFestival = festivals[position];
            String toastMessage;

            if (selectedFestival.equals("Christmas")) {
                toastMessage = "Marry " + selectedFestival;
                Toast.makeText(l6exercise3.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
            else if (selectedFestival.equals("Eid")) {
                toastMessage =  selectedFestival + " Mubarak" ;
                Toast.makeText(l6exercise3.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
            else {
                toastMessage = "Happy " + selectedFestival;
                Toast.makeText(l6exercise3.this, toastMessage, Toast.LENGTH_SHORT).show();

            }
        });
    }
}