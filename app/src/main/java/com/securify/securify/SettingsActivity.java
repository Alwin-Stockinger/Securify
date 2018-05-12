package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.securify.securify.model.MainModel;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText userNameInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();

        MainModel model=new MainModel(getApplicationContext());

        //Assign layout items
        userNameInput=findViewById(R.id.user_name_inputfield);
        userNameInput.setText(model.getActiveUser().getName());
        Button userNameButton=findViewById(R.id.user_name_confirm_btn);
        userNameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        MainModel model=new MainModel(getApplicationContext());
        model.changeUser(userNameInput.getText().toString());



        ImageButton backButton = findViewById(R.id.backButton);
        Button changeLang = findViewById(R.id.changeLanguage);
    }
}
