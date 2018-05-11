package com.securify.securify;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.securify.securify.model.achievementModels.AchievementModel;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.MainModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input;
    private TextView constraint1;
    private TextView constraint2;
    private TextView constraint3;

    private ImageView constraint1_icon;
    private ImageView constraint2_icon;
    private ImageView constraint3_icon;

    private TextView prozent_view;

    private Button password_confirm_button;

    private ImageButton backBtn;

    private MainModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_game);


        //Model things
        model=new MainModel(getApplicationContext());
        PasswordModel gameModel=model.getPassGameById(1);

        final int minLength=gameModel.getMin_length();
        final int maxLength=gameModel.getMax_length();



        //Assigning views
        constraint1 = findViewById(R.id.password_constraint1);
        constraint2 = findViewById(R.id.password_constraint2);
        constraint3 = findViewById(R.id.password_constraint3);

        //database text
        constraint2.setText("mindestens "+minLength+" und maximal "+maxLength+" Zeichen " + "(0)");


        constraint1.setTextColor(Color.RED);
        constraint2.setTextColor(Color.RED);
        constraint3.setTextColor(Color.RED);

        constraint1_icon = findViewById(R.id.constraint1_icon_id);
        constraint2_icon = findViewById(R.id.constraint2_icon_id);
        constraint3_icon = findViewById(R.id.constraint3_icon_id);

        input = findViewById(R.id.password_inputfield);

        prozent_view = findViewById(R.id.password_prozent);

        backBtn = findViewById(R.id.password_game_backBtn);
        backBtn.setOnClickListener(this);

        password_confirm_button = findViewById(R.id.password_confirm_btn);
        password_confirm_button.setOnClickListener(this);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable mEdit) {

                String entryText = mEdit.toString();

                char ch;
                constraint2.setText("mindestens "+minLength+" und maximal "+maxLength+" Zeichen " + "(" + entryText.length() + ")");

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

                if (capitalFlag) {
                    constraint1.setTextColor(Color.GREEN);
                    constraint1_icon.setImageResource(R.mipmap.true_icon);
                }
                    else {
                    constraint1.setTextColor(Color.RED);
                    constraint1_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }
                if (digitFlag) {
                    constraint3.setTextColor(Color.GREEN);
                    constraint3_icon.setImageResource(R.mipmap.true_icon);
                }
                    else {
                    constraint3.setTextColor(Color.RED);
                    constraint3_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }

                if(entryText.length() < minLength || entryText.length() > maxLength) {
                    constraint2.setTextColor(Color.RED);
                    constraint2_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }
                else {
                    constraint2.setTextColor(Color.GREEN);
                    constraint2_icon.setImageResource(R.mipmap.true_icon);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

    }

    @Override
    public void onClick(View view) {
        /*

        Das ist der Algorithmus für das Passwort-Spiel, hier wird einfach nur geschaut, wieviele Zeichen
        der User verwendet, wieviele Großbuchstaben, Zahlen und Sonderzeichen er eingegeben hat und
        je nachdem wird der Prozentsatz ausgerechnet, nach dem Prinzip je mehr Großbuchstaben, Zahlen
        und Sonderzeichen, desto mehr "Bonus-Prozente", der User soll halt nichts davon wissen und durch
        rausprobieren herausfinden, wie er am meisten die Prozente erreicht. Für Sonderzeichen gibt es
        die meisten Bonus-Prozente. Ist aber erst die Demoversion, ich überlege mir noch paar komplexere
        Sachen, das Layout des Spiels wird in etwa so aussehen wie es zurzeit aussieht, nur ordentlicher
        und ohne Fehler natürlich :)

         */

        switch (view.getId()) {

            case R.id.password_confirm_btn:
                if (constraint1.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if (constraint2.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if (constraint3.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                String inputText = input.getText().toString();
                char ch;
                int percentage = 0;

                //checking here for special symbols
                Pattern p = Pattern.compile("[^A-Za-z0-9]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(inputText);
                boolean special_symbol_bool = m.find();

                int counterDigit = 0;
                int counterUpper = 0;
                int counterSpecial_Symbol = 0;
                int counterLetter = 0;

                for (int i = 0; i < inputText.length(); i++) {
                    ch = inputText.charAt(i);

                    if (!Character.isUpperCase(ch) && !Character.isDigit(ch) && Character.isLetter(ch)) {
                        counterLetter++;
                        if (counterLetter <= 3) percentage += 5; //20
                        else if (counterLetter <= 8 && counterLetter > 3) percentage += 3; //15
                        else if (counterLetter >= 9) percentage += 1; //6
                    }

                    if (Character.isUpperCase(ch)) {
                        counterUpper++;
                        if (counterUpper == 1) percentage += 5;
                        if (counterUpper == 2) percentage += 4;
                        if (counterUpper == 3) percentage += 3;
                        if (counterUpper == 4) percentage += 2;
                        if (counterUpper >= 5) percentage += 1;
                        //16
                    }
                    else if (Character.isDigit(ch)) {
                        counterDigit++;
                        if (counterDigit == 1) percentage += 8;
                        if (counterDigit == 2) percentage += 5;
                        if (counterDigit == 3) percentage += 3;
                        if (counterDigit == 4) percentage += 2;
                        if (counterDigit >= 5) percentage += 1;
                        //19
                    }
                    else if (!Character.isLetter(ch)){
                        counterSpecial_Symbol++;
                        if (counterSpecial_Symbol == 1) percentage += 9;
                        if (counterSpecial_Symbol == 2) percentage += 7;
                        if (counterSpecial_Symbol == 3) percentage += 5;
                        if (counterSpecial_Symbol == 4) percentage += 3;
                        if (counterSpecial_Symbol >= 5) percentage += 1;
                        //25
                    }

                }

                //Achievements
                if (percentage >= 60 && model.achievementSuccess(1)) {
                    Toast.makeText(PasswordActivity.this,
                            "Sie haben den Erfolg " + model.getAchievement(1).getTitle() + " erreicht!",
                            Toast.LENGTH_LONG).show();
                }
                else if (percentage >= 65 && counterSpecial_Symbol <= 2 && model.achievementSuccess(2)) {
                    Toast.makeText(PasswordActivity.this,
                            "Sie haben den Erfolg " + model.getAchievement(2).getTitle() + " erreicht!",
                            Toast.LENGTH_LONG).show();
                }
                else if (percentage >= 70  && counterDigit <= 2 && counterSpecial_Symbol <= 2 && model.achievementSuccess(3)) {
                    Toast.makeText(PasswordActivity.this,
                            "Sie haben den Erfolg " + model.getAchievement(3).getTitle() + " erreicht!",
                            Toast.LENGTH_LONG).show();
                }

                prozent_view.setText(Integer.toString(percentage) + "%");
                break;
        }
    }

}
