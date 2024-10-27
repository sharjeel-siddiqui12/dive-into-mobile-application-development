package com.example.lab7;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;

public class L7exercise3 extends AppCompatActivity {

    private NetworkReceiver networkReceiver;
    private TextView connectionStatusText;
    private TextView connectionTypeText;
    private ImageView connectionImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7exercise3);

        connectionStatusText = findViewById(R.id.connectionStatusText);
        connectionTypeText = findViewById(R.id.connectionTypeText);
        connectionImageView = findViewById(R.id.connectionImageView);

        networkReceiver = new NetworkReceiver(
                connectionStatusText,
                connectionTypeText,
                connectionImageView
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
    }
}