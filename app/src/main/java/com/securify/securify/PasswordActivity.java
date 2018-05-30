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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.gameModels.PasswordModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.graphics.Color.parseColor;

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
    private ImageButton hintButton;
    private TextView hint_text;
    private int clickCounter = 0;
    private String inputText;
    private String inputText2;

    private MainModel model;
    private PasswordModel gameModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_game);


        //Model things
        model=new MainModel(getApplicationContext());
        gameModel=model.getRandomPasswordGame();

        final int minLength=gameModel.getMin_length();
        final int maxLength=gameModel.getMax_length();

        //HINT SETTINGS
        hint_text = findViewById(R.id.password_hint_text);
        hint_text.setText(gameModel.getTipp());
        hint_text.setVisibility(View.GONE);
        hint_text.setTextColor(parseColor("#5e4ceb"));

        //Assigning views
        constraint1 = findViewById(R.id.password_constraint1);
        constraint2 = findViewById(R.id.password_constraint2);
        constraint3 = findViewById(R.id.password_constraint3);

        //database text
        constraint1.setText("mindestens "+gameModel.getMin_upper()+" Großbuchstaben");
        constraint2.setText("mindestens "+minLength+" und maximal "+maxLength+" Zeichen " + "(0)");
        constraint3.setText("mindestens "+gameModel.getMin_number()+" Zahlen");


        constraint1.setTextColor(Color.RED);
        constraint2.setTextColor(Color.RED);
        constraint3.setTextColor(Color.RED);

        constraint1_icon = findViewById(R.id.constraint1_icon_id);
        constraint2_icon = findViewById(R.id.constraint2_icon_id);
        constraint3_icon = findViewById(R.id.constraint3_icon_id);

        input = findViewById(R.id.password_inputfield);

        prozent_view = findViewById(R.id.password_prozent);

        backBtn = findViewById(R.id.password_game_backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           finish();
                                       }
                                   });
        password_confirm_button = findViewById(R.id.password_confirm_btn);
        password_confirm_button.setOnClickListener(this);
        hintButton = findViewById(R.id.password_hint_button);
        hintButton.setOnClickListener(this);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable mEdit) {

                String entryText = mEdit.toString();

                char ch;
                constraint2.setText("mindestens "+minLength+" und maximal "+maxLength+" Zeichen " + "(" + entryText.length() + ")");

                boolean digitFlag = false;
                boolean capitalFlag = false;

                int digits=0;
                int capitals=0;

                for (int i = 0; i < entryText.length(); i++) {
                    ch = entryText.charAt(i);
                    if (Character.isDigit(ch)) {
                        digits++;
                    }
                }

                for (int i = 0; i < entryText.length(); i++) {
                    ch = entryText.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        capitals++;
                    }
                }

                if (capitals>=gameModel.getMin_upper()) {
                    constraint1.setTextColor(getResources().getColor(R.color.calmGreen));
                    constraint1_icon.setImageResource(R.mipmap.true_icon);
                }
                    else {
                    constraint1.setTextColor(Color.RED);
                    constraint1_icon.setImageResource(R.mipmap.ic_launcher_false_icon);
                }
                if (digits>=gameModel.getMin_number()) {
                    constraint3.setTextColor(getResources().getColor(R.color.calmGreen));
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
                    constraint2.setTextColor(getResources().getColor(R.color.calmGreen));
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

            case R.id.password_hint_button:
                hint_text.setVisibility(View.VISIBLE);
                break;

            case R.id.password_confirm_btn:
                clickCounter++;

                if (constraint1.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    input.setText("");
                    clickCounter = 0;
                    return;
                }

                if (constraint2.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    input.setText("");
                    clickCounter = 0;
                    return;
                }

                if (constraint3.getCurrentTextColor() == Color.RED) {
                    Toast.makeText(PasswordActivity.this,
                            "Halten Sie bitte die Passwort-Voraussetzungen ein!",
                            Toast.LENGTH_LONG).show();
                    input.setText("");
                    clickCounter = 0;
                    return;
                }

                if (clickCounter == 1) {
                    inputText = input.getText().toString();
                    Toast.makeText(PasswordActivity.this,
                            "Passwort bitte nochmal eingeben!",
                            Toast.LENGTH_LONG).show();
                    input.setText("");
                    break;
                }
                if (clickCounter == 2) {
                    inputText2 = input.getText().toString();
                    if (inputText.equals(inputText2)) {
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
                        percentage *= (15.0/gameModel.getMax_length());


                        //if password was already used in an earlier gamy by this user, the percantage will be decreased by 5% for every time it was used
                        percentage-=5*model.amountPassworUsed(inputText);

                        input.setText("");

                        //insert password as used, so it will bring disadvantage if used again
                        model.setPasswordUsed(inputText);

                        //passwort cannot be smaller than 0%..
                        if (percentage < 0)
                            percentage = 0;

                        //set highscore
                        model.setUserPasswordHighscore(percentage);


                        //Geschafft
                        if(percentage>=60){
                            model.setPasswordSucceeded(gameModel,true);
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
                        }
                        else model.setPasswordSucceeded(gameModel,false);



                        prozent_view.setText(Integer.toString(percentage) + "%");
                        clickCounter = 0;
                        inputText = "";
                        inputText2 = "";
                        input.setText("");
                        break;
                    }
                    else {
                        input.setText("");
                        Toast.makeText(PasswordActivity.this,
                                "Passwörter stimmen nicht überein! Versuchen Sie es erneut.",
                                Toast.LENGTH_LONG).show();
                        clickCounter = 0;
                        break;
                    }
                }
        }
    }

}
