    package com.example.lab7;

    import android.os.Bundle;
    import androidx.appcompat.app.AppCompatActivity;
    import com.example.mad_lab.R;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.view.View;
    import android.widget.Button;

    public class L7exercise1 extends AppCompatActivity {

        private MyReceiver myReceiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_l7exercise1);

            myReceiver = new MyReceiver();

            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            filter.addAction(Intent.ACTION_BATTERY_LOW);
            filter.addAction(Intent.ACTION_DATE_CHANGED);
            registerReceiver(myReceiver, filter);

            Button broadcastButton = findViewById(R.id.broadcast_button);
            broadcastButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    broadcastIntent();
                }
            });
        }

        private void broadcastIntent() {
            Intent intent = new Intent("com.example.broadcastreceivers.CUSTOM_ACTION");
            sendBroadcast(intent);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            unregisterReceiver(myReceiver);
        }
    }