package com.example.lab7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;

public class L7exercise2 extends AppCompatActivity {

    private EditText timeEditText;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7exercise2);

        timeEditText = findViewById(R.id.timeEditText);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        setAlarmButton.setOnClickListener(v -> setAlarm());
    }

    private void setAlarm() {
        try {
            int minutes = Integer.parseInt(timeEditText.getText().toString());

            long triggerTime = System.currentTimeMillis() + (minutes * 60 * 1000);

            Intent intent = new Intent(this, com.example.lab7.AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);

            Toast.makeText(this,
                    "Alarm set for " + minutes + " minutes from now",
                    Toast.LENGTH_LONG).show();

        } catch (NumberFormatException e) {
            Toast.makeText(this,
                    "Please enter a valid number of minutes",
                    Toast.LENGTH_SHORT).show();
        }
    }
}