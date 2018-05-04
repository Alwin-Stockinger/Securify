package com.securify.securify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        constraint1_icon = findViewById(R.id.constraint1_icon_id);
        constraint2_icon = findViewById(R.id.constraint2_icon_id);
        constraint3_icon = findViewById(R.id.constraint3_icon_id);

        input = findViewById(R.id.password_inputfield);

        prozent_view = findViewById(R.id.password_prozent);

        password_confirm_button = findViewById(R.id.password_confirm_btn);
        password_confirm_button.setOnClickListener(this);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable mEdit) {

                String entryText = mEdit.toString();

                char ch;
                constraint2.setText("mindestens 5 und maximal 15 Zeichen " + "(" + entryText.length() + ")");

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
                    constraint1_icon.setImageResource(R.mipmap.ic_launcher_true_icon);
                }
                    else {
                    constraint1.setTextColor(Color.RED);
                    constraint1_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }
                if (digitFlag) {
                    constraint3.setTextColor(Color.GREEN);
                    constraint3_icon.setImageResource(R.mipmap.ic_launcher_true_icon);
                }
                    else {
                    constraint3.setTextColor(Color.RED);
                    constraint3_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }

                if(entryText.length() <= 4 || entryText.length() >= 16) {
                    constraint2.setTextColor(Color.RED);
                    constraint2_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }
                else {
                    constraint2.setTextColor(Color.GREEN);
                    constraint2_icon.setImageResource(R.mipmap.ic_launcher_true_icon);
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

        for (int i = 0; i < inputText.length(); i++) {
            ch = inputText.charAt(i);
            if (Character.isUpperCase(ch)) {
                counterUpper++;
                if (counterUpper == 1) percentage += 6;
                if (counterUpper == 2) percentage += 4;
                if (counterUpper == 3) percentage += 3;
                if (counterUpper == 4) percentage += 2;
                if (counterUpper >= 5) percentage += 1;
            }
            if (Character.isDigit(ch)) {
                counterDigit++;
                if (counterDigit == 1) percentage += 8;
                if (counterDigit == 2) percentage += 5;
                if (counterDigit == 3) percentage += 3;
                if (counterDigit == 4) percentage += 2;
                if (counterDigit >= 5) percentage += 1;
            }
            if (special_symbol_bool) {
                counterSpecial_Symbol++;
                if (counterSpecial_Symbol == 1) percentage += 10;
                if (counterSpecial_Symbol == 2) percentage += 8;
                if (counterSpecial_Symbol == 3) percentage += 5;
                if (counterSpecial_Symbol == 4) percentage += 3;
                if (counterSpecial_Symbol >= 5) percentage += 1;
            }

        }
        if (inputText.length() > 10) percentage += 10;
            else percentage += inputText.length();

        prozent_view.setText(Integer.toString(percentage) + "%");
    }

}
