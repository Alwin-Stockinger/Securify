package com.securify.securify;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

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
    }

}
