package com.example.lab6;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class l6exercise1 extends AppCompatActivity {

    private String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6exercise1);

        TextView selectedDayTextView = findViewById(R.id.selectedDayTextView);
        ListView weekdaysListView = findViewById(R.id.weekdaysListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, weekdays);
        weekdaysListView.setAdapter(adapter);

        weekdaysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected day from the list and update the TextView
                String selectedDay = weekdays[position];
                selectedDayTextView.setText("Selected day: " + selectedDay);
            }
        });
    }
}