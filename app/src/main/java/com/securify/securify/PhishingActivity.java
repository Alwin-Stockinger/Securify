package com.securify.securify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.gameModels.PhishingModel;

import java.util.Timer;
import java.util.TimerTask;

public class PhishingActivity extends AppCompatActivity implements View.OnClickListener{

    private Button spam_btn;
    private Button no_spam_btn;
    private ImageButton hint_Btn;

    private TextView context;

    private TextView resultText;
    private ImageView resultIcon;

    private TextView hint_text;

    //Timer variables
    final Timer time = new Timer();
    private TextView counter;
    private int timerSeconds;

    // Model things
    MainModel mModel;
    PhishingModel phModel;

    private TextView explanationText;

    boolean decisionUser;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phishing_game);

        mModel = new MainModel(getApplicationContext());
        phModel = mModel.getRandomPhishingGame();

        context = findViewById(R.id.mail_view_id);

        resultText = findViewById(R.id.phishing_result_text);

        resultIcon = findViewById(R.id.phishing_result_icon);
        resultIcon.setVisibility(View.GONE);


        timerSeconds = phModel.getZeit();
        context.setText("Absender " + phModel.getAbsender() + "\n" + "\n" + "Betreff: " +
                phModel.getBetreff() + "\n" + "\n" + phModel.getKontext());

        context.setMovementMethod(new ScrollingMovementMethod());
        context.setScrollbarFadingEnabled(false);

        spam_btn = findViewById(R.id.spam_btn);
        spam_btn.setBackgroundColor(Color.GREEN);
        spam_btn.setOnClickListener(this);

        no_spam_btn = findViewById(R.id.no_spam_btn);
        no_spam_btn.setBackgroundColor(Color.RED);
        no_spam_btn.setOnClickListener(this);

        hint_Btn = findViewById(R.id.hint_phishing_id);
        hint_Btn.setOnClickListener(this);

        explanationText = findViewById(R.id.phishing_explanationFalse_id);
        explanationText.setVisibility(View.GONE);
        explanationText.setTextColor(Color.RED);
        explanationText.setText(phModel.getErklaerung());

        counter = findViewById(R.id.counter_phishing_id);

        //HINT SETTINGS
        hint_text = findViewById(R.id.phishing_hint_text_id);
        hint_text.setText(phModel.getTipp());
        hint_text.setVisibility(View.GONE);
        hint_text.setTextColor(Color.parseColor("#5e4ceb"));

        //Timer settings
        int delay = 1000;
        int period = 1000;
        counter.setText(Integer.toString(timerSeconds));

        time.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (timerSeconds == 1) {
                    time.cancel();
                    time.purge();
                    checkBool(phModel.isIs_phishing());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.clearAnimation();;
                        }
                    });
                    setTimerSeconds();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.setText(Integer.toString(getTimerSeconds()));
                        }
                    });
                    spam_btn.setClickable(false);
                    no_spam_btn.setClickable(false);

                } else {
                    setTimerSeconds();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.setText(Integer.toString(getTimerSeconds()));
                        }
                    });
                    if (timerSeconds <= 10) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                                anim.setDuration(50);
                                anim.setStartOffset(20);
                                anim.setRepeatMode(Animation.REVERSE);
                                anim.setRepeatCount(Animation.INFINITE);
                                counter.startAnimation(anim);
                                counter.setTextColor(Color.RED);
                            }
                        });
                    }
                }
            }
        }, delay, period);


    }

    private int setTimerSeconds() {

        return --timerSeconds;
    }

    private int getTimerSeconds() {
        return timerSeconds;
    }

    private void checkBool (boolean isPhishing) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    counter.clearAnimation();
                    resultText.setText("Falsch!");
                    resultText.setTextColor(Color.RED);
                    resultIcon.setVisibility(View.VISIBLE);
                    resultIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    explanationText.setVisibility(View.VISIBLE);
                    hint_Btn.setClickable(false);
                }
            });
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.hint_phishing_id:
                hint_text.setVisibility(View.VISIBLE);
                break;


            case R.id.spam_btn:
                decisionUser = true;
                if (phModel.isIs_phishing() != decisionUser) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.clearAnimation();
                            resultText.setText("Falsch!");
                            resultText.setTextColor(Color.RED);
                            resultIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                            resultIcon.setVisibility(View.VISIBLE);
                            explanationText.setVisibility(View.VISIBLE);
                            hint_Btn.setClickable(false);
                        }
                    });
                }
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.clearAnimation();
                            resultText.setText("Richtig!");
                            resultText.setTextColor(Color.GREEN);
                            resultIcon.setImageResource(R.mipmap.true_icon);
                            resultIcon.setVisibility(View.VISIBLE);
                            hint_Btn.setClickable(false);
                        }
                    });
                }
                time.cancel();
                time.purge();

                spam_btn.setClickable(false);
                no_spam_btn.setClickable(false);
                break;

            case R.id.no_spam_btn:
                decisionUser = false;
                if (phModel.isIs_phishing() != decisionUser) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.clearAnimation();
                            resultText.setText("Falsch!");
                            resultText.setTextColor(Color.RED);
                            resultIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                            resultIcon.setVisibility(View.VISIBLE);
                            explanationText.setVisibility(View.VISIBLE);
                            hint_Btn.setClickable(false);
                        }
                    });
                }
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.clearAnimation();
                            resultText.setText("Richtig!");
                            resultText.setTextColor(Color.GREEN);
                            resultIcon.setImageResource(R.mipmap.true_icon);
                            resultIcon.setVisibility(View.VISIBLE);
                            hint_Btn.setClickable(false);
                        }
                    });
                }
                time.cancel();
                time.purge();

                spam_btn.setClickable(false);
                no_spam_btn.setClickable(false);
                break;

        }
    }
}