package com.example.chikakodama.calendarproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClearEventDialog extends DialogFragment {

    private EditText yearEditText;
    private EditText monthEditText;
    private EditText dayEditText;
    private Button cancelBtn;
    private Button okBtn;

    //This class is setting up the dialog, or DialogFragment, that appears when Clear button is pressed in the Calendar tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Remove period");
        View rootView = inflater.inflate(R.layout.clear_event_dialog, container, false);
        dayEditText = rootView.findViewById(R.id.dayEditText);
        monthEditText = rootView.findViewById(R.id.monthEditText);
        yearEditText = rootView.findViewById(R.id.yearEditText);
        cancelBtn = rootView.findViewById(R.id.cancelBtn);
        okBtn = rootView.findViewById(R.id.okBtn);                                              //initializing


        cancelBtn.setOnClickListener(new View.OnClickListener() {                           //when Cancel button is clicked on
            @Override
            public void onClick(View v) {
                getDialog().dismiss();                                                          //dialog will be dismissed
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {                               //when Ok button is clicked on
            @Override
            public void onClick(View v) {
                String inputMonth = monthEditText.getText().toString();
                String inputDay = dayEditText.getText().toString();
                String inputYear = yearEditText.getText().toString();
                int inputMonthInt = Integer.parseInt(inputMonth);
                int inputDayInt = Integer.parseInt(inputDay);
                int inputYearInt = Integer.parseInt(inputYear);                             //input (the date) will be taken in

                if (!inputMonth.equals("") && !inputDay.equals("") && !inputYear.equals("")) {
                    Event event = new Event(inputYearInt, inputMonthInt, inputDayInt, "");
                    Intent intent = new Intent(ClearEventDialog.this, Tab1Calendar.class);           //intent is created with a blank string
                    intent.putExtra("clear", event);                                                   //data from input is stored
                    startActivity(intent);                                                              //then sent out
                }


                getDialog().dismiss();                                                          //dialog will be dismissed
            }
        });

        return rootView;
    }
}