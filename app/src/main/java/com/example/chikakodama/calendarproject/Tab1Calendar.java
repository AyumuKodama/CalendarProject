package com.example.chikakodama.calendarproject;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;

public class Tab1Calendar extends Fragment {

    private Button addBtn;
    private Button clearBtn;
    private TextView eventText;
    private CalendarView calendarView;
    private static final String TAG = "Tab1Calendar";
    ArrayList<Event> list = new ArrayList<Event>();
    private Event event;

    public Tab1Calendar() {
    }

    //This class is the first tab in the app, the Calendar tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_calendar, container, false);
        calendarView = rootView.findViewById(R.id.calendarView);
        eventText = rootView.findViewById(R.id.events);
        addBtn = rootView.findViewById(R.id.addBtn);
        clearBtn = rootView.findViewById(R.id.clearBtn);        //initializing


        addBtn.setOnClickListener(new View.OnClickListener() {              //when Add button is clicked on
            @Override
            public void onClick(View v) {
                addEventDialog dialog = new AddEventDialog();
                dialog.show(getFragmentManager(), "AddEventDialog");        //Add Event dialog will pop up
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {            //when Clear button is clicked on
            @Override
            public void onClick(View v) {
                clearEventDialog dialog = new ClearEventDialog();
                dialog.show(getFragmentManager(), "ClearEventDialog");      //Clear Event dialog will pop up
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {      //when date is highlighted
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = month + 1 + "/" + dayOfMonth + "/" + year;
                Log.d(TAG, "onSelectedDayChange : date" + date);
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getDayOfMonth() == dayOfMonth) &&
                            (list.get(i).getMonth() == month) &&
                            (list.get(i).getYear() == year)) {
                        eventText.setText(list.get(i).getEvent());              //event for that date will show up in text below calendar
                    }
                }


            }
        });

        if (getIntent().hasExtra("event")) {                    //if intent has event name and date inside
            list.add(getIntent().getExtras());                  //event is added to the list
        } else if (getIntent().hasExtra("clear")) {             //if intent has blank string and date inside
            Event event = getIntent().getExtras();
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).getDayOfMonth() == event.getDayOfMonth()) && (list.get(i).getMonth() == event.getMonth())
                        && (list.get(i).getYear() == event.getYear())) {
                    list.remove(i);                                         //every event for that date is deleted
                }
            }
        }


        return rootView;
    }
}
