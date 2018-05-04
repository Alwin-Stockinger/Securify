package com.securify.securify;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    private EditText input;

    private TextView constraint1;
    private TextView constraint2;
    private TextView constraint3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_game);


        //Assigning views
        constraint1 = findViewById(R.id.password_constraint1);
        constraint2 = findViewById(R.id.password_constraint2);
        constraint3 = findViewById(R.id.password_constraint3);

        constraint1.setTextColor(Color.RED);
        constraint2.setTextColor(Color.RED);
        constraint3.setTextColor(Color.RED);

        input = findViewById(R.id.password_inputfield);

        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable mEdit) {

                String entryText = mEdit.toString();
                char ch;
                constraint2.setText("-mindestens 5 und maximal 15 Zeichen " + "(" + entryText.length() + ")");

                boolean digitFlag = false;
                boolean capitalFlag = false;

                for (int i = 0; i < entryText.length(); i++) {
                    ch = entryText.charAt(i);
                    if (Character.isDigit(ch)) {
                        digitFlag = true;
                        break;
                    }
                }

                for (int i = 0; i < entryText.length(); i++) {
                    ch = entryText.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        capitalFlag = true;
                        break;
                    }
                }

                if (capitalFlag) constraint1.setTextColor(Color.GREEN);
                else constraint1.setTextColor(Color.RED);
                if (digitFlag) constraint3.setTextColor(Color.GREEN);
                else constraint3.setTextColor(Color.RED);

                if(entryText.length() <= 4 || entryText.length() >= 16)
                    constraint2.setTextColor(Color.RED);
                else constraint2.setTextColor(Color.GREEN);

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

    }

}
