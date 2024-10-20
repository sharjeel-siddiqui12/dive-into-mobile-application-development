package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.widget.Toast;

public class l6exercise2 extends AppCompatActivity {

    private String[] operatingSystems = {"Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6exercise2);

        ListView osListView = findViewById(R.id.osListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operatingSystems);
        osListView.setAdapter(adapter);

        osListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOS = operatingSystems[position];
                Toast.makeText(l6exercise2.this, "Selected: " + selectedOS, Toast.LENGTH_SHORT).show();
            }
        });
    }
}