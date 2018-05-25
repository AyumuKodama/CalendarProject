package com.example.chikakodama.calendarproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RemovePeriodDialog extends DialogFragment {

    private EditText periodEditText;
    private Button cancelBtn;
    private Button okBtn;

    //This class sets up the dialog that appears when the Remove button is clicked on the Schedule tab.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Remove period");
        View rootView = inflater.inflate(R.layout.remove_period_dialog, container, false);
        periodEditText = rootView.findViewById(R.id.periodEditText);
        cancelBtn = rootView.findViewById(R.id.cancelBtn);
        okBtn = rootView.findViewById(R.id.okBtn);
        TextView period1 = rootView.findViewById(R.id.period_1);
        TextView period2 = rootView.findViewById(R.id.period_2);
        TextView period3 = rootView.findViewById(R.id.period_3);
        TextView period4 = rootView.findViewById(R.id.period_4);
        TextView period5 = rootView.findViewById(R.id.period_5);
        TextView period6 = rootView.findViewById(R.id.period_6);
        TextView period7 = rootView.findViewById(R.id.period_7);            //initializing

        cancelBtn.setOnClickListener(new View.OnClickListener() {               //when Cancel button is clicked on
            @Override
            public void onClick(View v) {
                getDialog().dismiss();                                             //dialog will be dismissed
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {                   //when Ok button is clicked on
            @Override
            public void onClick(View v) {
                String inputPeriod = periodEditText.getText().toString();
                int inputPeriodInt = Integer.parseInt(inputPeriod);                 //takes in input (the period number)

                if (inputPeriodInt == 1) {
                    period1.setText("");
                } else if (inputPeriodInt == 2) {
                    period2.setText("");
                } else if (inputPeriodInt == 3) {
                    period3.setText("");
                } else if (inputPeriodInt == 4) {
                    period4.setText("");
                } else if (inputPeriodInt == 5) {
                    period5.setText("");
                } else if (inputPeriodInt == 6) {
                    period6.setText("");
                } else if (inputPeriodInt == 7) {
                    period7.setText("");                                        //class name on right column will be removed
                }
                getDialog().dismiss();                                           //dialog will be dismissed
            }
        });

        return rootView;


    }
}