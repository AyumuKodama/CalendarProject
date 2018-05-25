package com.example.chikakodama.calendarproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tab3Email extends Fragment {

    //This class is the third tab in the app, or the Email app.

    private TextView addressText;
    private EditText addressName;
    private TextView mailText;
    private EditText mailContent;
    private Button clearBtn;
    private Button sendBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_email, container, false);

        addressText = rootView.findViewById(R.id.addressText);
        addressName = rootView.findViewById(R.id.addressName);
        mailText = rootView.findViewById(R.id.mailText);
        mailContent = rootView.findViewById(R.id.mailContent);
        clearBtn = rootView.findViewById(R.id.clearBtn);
        sendBtn = rootView.findViewById(R.id.sendBtn);                      //initializing

        clearBtn.setOnClickListener(new View.OnClickListener() {            //if clear button is clicked on
            @Override
            public void onClick(View v) {
                addressName.setText("");
                mailContent.setText("");                                    //mail contents are cleared
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {         //if send button is clicked on
            @Override
            public void onClick(View v) {
                String mail = mailContent.toString()
                String address = addressName.toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, mail);
                email.setType(address);
                getActivity().startActivity(Intent.createChooser(email, "email"));      //email is sent

            }
        });

        return rootView;
    }
}
