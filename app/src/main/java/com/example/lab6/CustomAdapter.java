package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_lab.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Item>{
    public CustomAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView iconImageView = convertView.findViewById(R.id.iconImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);

        iconImageView.setImageResource(item.getIcon());
        nameTextView.setText(item.getName());

        return convertView;
    }
}


