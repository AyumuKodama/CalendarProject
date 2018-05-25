package com.example.chikakodama.calendarproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.FragmentTransaction;
import android.widget.TextView;

public class Tab2Schedule  extends Fragment {

    private Button addBtn;
    private Button removeBtn;
    private static final String TAG = "Tab2Schedule";

    //This class is the second tab in the app, or the Schedule tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_schedule, container, false);
        addBtn = rootView.findViewById(R.id.addBtn);
        removeBtn = rootView.findViewById(R.id.removeBtn);                  //initializing

        addBtn.setOnClickListener(new View.OnClickListener() {              //when Add button is clicked
            @Override
            public void onClick(View v) {
                AddPeriodDialog dialog = new AddPeriodDialog();
                dialog.show(getFragmentManager(), "AddPeriodDialog");       //Add Period dialog pops up
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {           //when Remove button is clicked
            @Override
            public void onClick(View v) {
                RemovePeriodDialog dialog = new RemovePeriodDialog();
                dialog.show(getFragmentManager(), "RemovePeriodDialog");       //Remove Period dialog pops up
            }
        });


        return rootView;


    }


}