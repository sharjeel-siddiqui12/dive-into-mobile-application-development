package com.example.lab6;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_lab.R;
import java.util.ArrayList;
import java.util.List;

public class l6exercise5 extends AppCompatActivity {

    private ListView listView;
    private List<Meal> mealList;
    private MealAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6exercise5);

        listView = findViewById(R.id.listView);

        mealList = new ArrayList<>();
        mealList.add(new Meal("Pizza", "Spicy Chicken Pizza" , 1000, R.drawable.pizza_image));
        mealList.add(new Meal("Burger", "Beef Burger",300, R.drawable.burger_image));
        mealList.add(new Meal("Pizza", "Chicken Pizza",900, R.drawable.chicken_pizza));
        mealList.add(new Meal("Burger", "Chicken Burger",320, R.drawable.chicken_burger));
        mealList.add(new Meal("Burger", "Fish Burger", 410, R.drawable.fish_burger));
        mealList.add(new Meal("Mango", "Mango Juice",150, R.drawable.mango_image));

        mealAdapter = new MealAdapter(this, mealList);
        listView.setAdapter(mealAdapter);
    }
}