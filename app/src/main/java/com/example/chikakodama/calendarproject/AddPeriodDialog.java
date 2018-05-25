package com.example.chikakodama.calendarproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddPeriodDialog extends DialogFragment {

    private Button cancelBtn;
    private Button okBtn;
    private EditText periodText;
    private EditText classText;

    //This class will be setting up the dialog, or  DialogFragment, that appears when the Add button is clicked on in the Schedule tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Add period");
        View rootView = inflater.inflate(R.layout.add_period_dialog, container, false);
        cancelBtn = rootView.findViewById(R.id.cancelBtn);
        okBtn = rootView.findViewById(R.id.okBtn);
        periodText = rootView.findViewById(R.id.periodEditText);
        classText = rootView.findViewById(R.id.classEditText);                      //initializing
        TextView period1 = rootView.findViewById(R.id.period_1);
        TextView period2 = rootView.findViewById(R.id.period_2);
        TextView period3 = rootView.findViewById(R.id.period_3);
        TextView period4 = rootView.findViewById(R.id.period_4);
        TextView period5 = rootView.findViewById(R.id.period_5);
        TextView period6 = rootView.findViewById(R.id.period_6);
        TextView period7 = rootView.findViewById(R.id.period_7);                        //initializing from Schedule tab

        cancelBtn.setOnClickListener(new View.OnClickListener() {                       //when cancel button is clicked on
            @Override
            public void onClick(View v) {
                getDialog().dismiss();                                                    //dialog will be dismissed
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {                              //when Ok button is pressed
            @Override
            public void onClick(View v) {
                String inputPeriod = periodText.getText().toString();
                String inputClass = classText.getText().toString();
                int inputPeriodInt = Integer.parseInt(inputPeriod);                         //input (the period and class) is taken in

                if (!inputPeriod.equals("")&& !inputClass.equals("")) {
                    if (inputPeriodInt == 1) {
                        period1.setText(inputClass);
                    } else if (inputPeriodInt == 2) {
                        period2.setText(inputClass);
                    } else if (inputPeriodInt == 3) {
                        period3.setText(inputClass);
                    } else if (inputPeriodInt == 4) {
                        period4.setText(inputClass);
                    } else if (inputPeriodInt == 5) {
                        period5.setText(inputClass);
                    } else if (inputPeriodInt == 6) {
                        period6.setText(inputClass);
                    } else if (inputPeriodInt == 7) {
                        period7.setText(inputClass);                                        //text in right column of schedule will change accordingly
                    }
                }
                getDialog().dismiss();                                                      //dialog will be dismissed
            }
        });

        return rootView;


    }
}