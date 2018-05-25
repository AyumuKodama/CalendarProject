package com.example.chikakodama.calendarproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEventDialog extends DialogFragment {

    private Button cancelBtn;
    private Button okBtn;
    private EditText monthEditText;
    private EditText dayEditText;
    private EditText yearEditText;
    private EditText eventEditText;

    //This class is setting up the dialog, or DialogFragment, that will appear when the Add button is clicked on in the Calendar tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Add event");
        View rootView = inflater.inflate(R.layout.add_event_dialog, container, false);
        cancelBtn = rootView.findViewById(R.id.cancelBtn);
        okBtn = rootView.findViewById(R.id.okBtn);
        monthEditText = rootView.findViewById(R.id.monthEditText);
        dayEditText = rootView.findViewById(R.id.dayEditText);
        yearEditText = rootView.findViewById(R.id.yearEditText);
        eventEditText = rootView.findViewById(R.id.eventEditText);                  //initializing

        cancelBtn.setOnClickListener(new View.OnClickListener() {                      //when Cancel button is pressed
            @Override
            public void onClick(View v) {                                       //when Cancel button is clicked on
                getDialog().dismiss();                                                  //dialog will be dismissed
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                               //when Ok button is clicked on
                String inputMonth = monthEditText.getText().toString();
                String inputDay = dayEditText.getText().toString();
                String inputYear = yearEditText.getText().toString();
                String inputEvent = eventEditText.getText().toString();
                int inputMonthInt = Integer.parseInt(inputMonth);
                int inputDayInt = Integer.parseInt(inputDay);
                int inputYearInt = Integer.parseInt(inputYear);                        //input (the date and event) is taken in

                if (!inputMonth.equals("") && !inputDay.equals("") && !inputYear.equals("")) {
                    Event event = new Event(inputYearInt, inputMonthInt, inputDayInt, inputEvent);
                    Intent intent = new Intent(AddEventDialog.this, Tab1Calendar.class);            //intent is created
                    intent.putExtra("event", event);                                                //data from input is stored
                    startActivity(intent);                                                           //then sent out
                }

                getDialog().dismiss();                                                                 //dialog will be dismissed
            }
        });

        return rootView;


    }
}