package com.example.lab3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_lab.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class L3exercise2Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l3exercise2_frag_main);

        // Create a new instance of BasicFragment
        L3exercise2Frag1 fragment = new L3exercise2Frag1();
        L3exercise2Frag2 fragment1 = new L3exercise2Frag2();

        // Get the FragmentManager and start a transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the fragment to the fragment_container (FrameLayout in activity_main.xml)
        fragmentTransaction.add(R.id.fragment1, fragment);
        fragmentTransaction.add(R.id.fragment2, fragment1);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}
