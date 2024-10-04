package com.example.lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mad_lab.R;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;


public class L3exercise3ListFrag extends ListFragment  {
    private TextView name, location;

    String[] users = { "John", "Cena", "Undertaker", "kane", "Reigns" };
    String[] locations = { "NY", "LA", "California", "washington", "Dallas"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_l3exercise3_list_items, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        L3exercise3DetailFrag detailsFragment = (L3exercise3DetailFrag) getFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.change("Name: " + users[position], "Location: " + locations[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}