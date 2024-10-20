package com.example.lab6;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;

import java.util.ArrayList;

public class l6exercise4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6exercise4);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.facebook_icon, "Facebook"));
        items.add(new Item(R.drawable.youtube_icon, "YouTube"));
        items.add(new Item(R.drawable.twitter_icon, "Twitter"));
        items.add(new Item(R.drawable.tiktok_icon, "TikTok"));
        items.add(new Item(R.drawable.instagram_icon, "Instagram"));
        items.add(new Item(R.drawable.snapchat_icon, "Snapchat"));
        items.add(new Item(R.drawable.whatsapp_icon, "WhatsApp"));

        CustomAdapter adapter = new CustomAdapter(this, items);

        ListView listView = findViewById(R.id.osListView);
        listView.setAdapter(adapter);
    }
}