package com.securify.securify;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.MainModel;

import java.util.Timer;
import java.util.TimerTask;


public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean gameResult = true;

    private ImageButton hint_Btn;

    private Switch camera;
    private Switch position;
    private Switch contact;
    private Switch sms;
    private Switch microphone;

    private TextView cameraText;
    private TextView positionText;
    private TextView contactText;
    private TextView smsText;
    private TextView microphoneText;

    private TextView counter;

    private int timerSeconds;


    MainModel mModel;
    PermissionModel pModel;

    boolean cameraBool;
    boolean positionBool;
    boolean contactBool;
    boolean smsBool;
    boolean microphoneBool;


    private ImageView cameraIcon;
    private ImageView positionIcon;
    private ImageView contactIcon;
    private ImageView smsIcon;
    private ImageView microphoneIcon;

    private Button finishBtn;

    final Timer time = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permissions_game);


        mModel = new MainModel(getApplicationContext());
        pModel = mModel.getPermGameById(1);

        timerSeconds = pModel.getZeit();

        cameraBool = pModel.isKamera();
        positionBool = pModel.isPosition();
        contactBool = pModel.isKontake();
        smsBool = pModel.isSms();
        microphoneBool = pModel.isMikrofon();

        //hint-Button
        hint_Btn = findViewById(R.id.hint_permission_id);

        //Assigning switches
        camera = findViewById(R.id.camera_id);
        position = findViewById(R.id.position_id);
        contact = findViewById(R.id.contact_id);
        sms = findViewById(R.id.sms_id);
        microphone = findViewById(R.id.microphone_id);

        //Assigning text for true/false view
        cameraText = findViewById(R.id.camera_text);
        positionText = findViewById(R.id.position_text);
        contactText = findViewById(R.id.contact_text);
        smsText = findViewById(R.id.sms_text);
        microphoneText = findViewById(R.id.microphone_text);

        //Assigning Imageviews for true and false icons
        cameraIcon = findViewById(R.id.camera_icon_id);
        positionIcon = findViewById(R.id.position_icon_id);
        contactIcon = findViewById(R.id.contact_icon_id);
        smsIcon = findViewById(R.id.sms_icon_id);
        microphoneIcon = findViewById(R.id.microphone_icon_id);

        //Assigning counter view
        counter = findViewById(R.id.counter_id);

        //Assigning buttons
        finishBtn = findViewById(R.id.permission_finish_btn);
        finishBtn.setOnClickListener(this);

        //Timer properties
        int delay = 1000;
        int period = 1000;
        counter.setText(Integer.toString(timerSeconds));

        time.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (timerSeconds == 1) {
                    time.cancel();
                    time.purge();
                    checkBool(camera.isChecked(), position.isChecked(), contact.isChecked(), sms.isChecked(), microphone.isChecked());
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
                    camera.setClickable(false);
                    position.setClickable(false);
                    contact.setClickable(false);
                    sms.setClickable(false);
                    microphone.setClickable(false);

                } else {
                    setTimerSeconds();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.setText(Integer.toString(getTimerSeconds()));
                        }
                    });
                    if (timerSeconds <= 5) {
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

    private void setTimerSecondsDirect(int value) {
        timerSeconds = value;
    }

    private int setTimerSeconds() {

        return --timerSeconds;
    }

    private int getTimerSeconds() {
        return timerSeconds;
    }

    private void checkBool(boolean cameraB, boolean positionB, boolean contactB, boolean smsB, boolean microphoneB) {
        if (cameraB != cameraBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    cameraIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    camera.setBackgroundColor(Color.parseColor("#ffd9d9"));
                    cameraText.setText("Falsch!");
                    cameraText.setTextColor(Color.RED);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    cameraIcon.setImageResource(R.mipmap.true_icon);
                    camera.setBackgroundColor(Color.parseColor("#d9ffe1"));
                    cameraText.setText("Richtig!");
                    cameraText.setTextColor(Color.GREEN);
                }
            });
        }

        if (positionB != positionBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    positionIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    position.setBackgroundColor(Color.parseColor("#ffd9d9"));
                    positionText.setText("Falsch!");
                    positionText.setTextColor(Color.RED);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    positionIcon.setImageResource(R.mipmap.true_icon);
                    position.setBackgroundColor(Color.parseColor("#d9ffe1"));
                    positionText.setText("Richtig!");
                    positionText.setTextColor(Color.GREEN);
                }
            });
        }

        if (contactB != contactBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contactIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    contact.setBackgroundColor(Color.parseColor("#ffd9d9"));
                    contactText.setText("Falsch!");
                    contactText.setTextColor(Color.RED);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contactIcon.setImageResource(R.mipmap.true_icon);
                    contact.setBackgroundColor(Color.parseColor("#d9ffe1"));
                    contactText.setText("Richtig!");
                    contactText.setTextColor(Color.GREEN);
                }
            });
        }

        if (smsB != smsBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    smsIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    sms.setBackgroundColor(Color.parseColor("#ffd9d9"));
                    smsText.setText("Falsch!");
                    smsText.setTextColor(Color.RED);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    smsIcon.setImageResource(R.mipmap.true_icon);
                    sms.setBackgroundColor(Color.parseColor("#d9ffe1"));
                    smsText.setText("Richtig!");
                    smsText.setTextColor(Color.GREEN);
                }
            });
        }
        if (microphoneB != microphoneBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    microphoneIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    microphone.setBackgroundColor(Color.parseColor("#ffd9d9"));
                    microphoneText.setText("Falsch!");
                    microphoneText.setTextColor(Color.RED);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    microphoneIcon.setImageResource(R.mipmap.true_icon);
                    microphone.setBackgroundColor(Color.parseColor("#d9ffe1"));
                    microphoneText.setText("Richtig!");
                    microphoneText.setTextColor(Color.GREEN);
                }
            });
        }


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.permission_finish_btn:
                setTimerSecondsDirect(0);
                time.cancel();
                time.purge();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        counter.clearAnimation();
                    }
                });
                camera.setClickable(false);
                position.setClickable(false);
                contact.setClickable(false);
                sms.setClickable(false);
                microphone.setClickable(false);
                checkBool(camera.isChecked(), position.isChecked(), contact.isChecked(), sms.isChecked(), microphone.isChecked());
                break;

        }
    }
}

