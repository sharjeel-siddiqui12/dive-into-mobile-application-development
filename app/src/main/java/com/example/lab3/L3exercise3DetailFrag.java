package com.example.lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.mad_lab.R;
import android.widget.TextView;

public class L3exercise3DetailFrag extends Fragment {
    private TextView name, location;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_l3exercise3_detail_info, container, false);
        name = view.findViewById(R.id.Name);
        location = view.findViewById(R.id.Location);
        return view;
    }

    public void change(String uname, String ulocation) {
        name.setText(uname);
        location.setText(ulocation);
    }
}