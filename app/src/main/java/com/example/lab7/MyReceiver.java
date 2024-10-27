package com.example.lab7;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver  {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(action)) {
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_BATTERY_LOW.equals(action)) {
            Toast.makeText(context, "Battery Low", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_DATE_CHANGED.equals(action)) {
            Toast.makeText(context, "Date Changed", Toast.LENGTH_SHORT).show();
        } else if ("com.example.broadcastreceivers.CUSTOM_ACTION".equals(action)) {
            Toast.makeText(context, "Custom Broadcast Received", Toast.LENGTH_SHORT).show();
        }
    }
}