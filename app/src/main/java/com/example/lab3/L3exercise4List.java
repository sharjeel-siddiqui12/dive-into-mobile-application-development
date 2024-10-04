package com.example.lab3;

import android.os.Bundle;
import com.example.mad_lab.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

public class L3exercise4List extends ListFragment    {
    String[] courses = { "CSS", "Go", "Ruby", "SQL", "Kotlin" };
    String[] details = { "CSS development course", "Go development course", "Ruby course", "SQL programming", "Kotlin development course" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_l3exercise3_list_items, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, courses);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        L3exercise3DetailFrag detailsFragment = (L3exercise3DetailFrag) getFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.change("Course: " + courses[position], "Details: " + details[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}