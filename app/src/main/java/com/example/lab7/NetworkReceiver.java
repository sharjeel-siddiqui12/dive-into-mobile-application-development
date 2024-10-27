package com.example.lab7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mad_lab.R;

public class NetworkReceiver extends BroadcastReceiver {
    private TextView connectionStatusText;
    private TextView connectionTypeText;
    private ImageView connectionImageView;

    public NetworkReceiver(TextView statusText, TextView typeText, ImageView imageView) {
        this.connectionStatusText = statusText;
        this.connectionTypeText = typeText;
        this.connectionImageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnected();

            connectionStatusText.setText(isConnected ? "Connected" : "Not Connected");

            if (isConnected) {
                int type = activeNetwork.getType();
                String connectionType = "Unknown";
                int imageResource = android.R.drawable.ic_delete; // default image

                if (type == ConnectivityManager.TYPE_WIFI) {
                    connectionType = "Wi-Fi";
                    imageResource = R.drawable.wifilogo ;
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    connectionType = "Mobile Data";
                    imageResource = R.drawable.mobile_data; // Mobile data icon
                }

                connectionTypeText.setText(connectionType);
                connectionImageView.setImageResource(imageResource);
            } else {
                connectionTypeText.setText("No Connection");
                connectionImageView.setImageResource(android.R.drawable.ic_dialog_alert);
            }
        }
    }
}