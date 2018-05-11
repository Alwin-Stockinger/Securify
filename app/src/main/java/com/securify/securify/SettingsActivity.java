package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ImageButton backButton = findViewById(R.id.backButton);
        Button changeLang = findViewById(R.id.changeLanguage);
        Button changeUname = findViewById(R.id.changeUsername);
    }
}
