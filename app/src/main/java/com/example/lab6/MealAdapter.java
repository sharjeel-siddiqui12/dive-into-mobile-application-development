package com.example.lab6;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mad_lab.R;

import java.util.List;

public class MealAdapter extends BaseAdapter {
    private Context context;
    private List<Meal> mealList;

    public MealAdapter(Context context, List<Meal> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public Object getItem(int position) {
        return mealList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_food, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView titleText = convertView.findViewById(R.id.item_title);
        TextView subtitleText = convertView.findViewById(R.id.item_subtitle);
        TextView priceText = convertView.findViewById(R.id.item_price);

        Meal meal = mealList.get(position);

        imageView.setImageResource(meal.getImageResId());
        titleText.setText(meal.getTitle());
        subtitleText.setText(meal.getSubtitle());
        priceText.setText("Rs. " + String.valueOf(meal.getPrice()));

        return convertView;
    }
}
