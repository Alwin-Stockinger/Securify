package com.securify.securify;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    private int timerSeconds = 15;



    boolean cameraBool = false;
    boolean positionBool = false;
    boolean contactBool = false;
    boolean smsBool = false;
    boolean microphoneBool = false;


    private ImageView cameraIcon;
    private ImageView positionIcon;
    private ImageView contactIcon;
    private ImageView smsIcon;
    private ImageView microphoneIcon;

    private Button finishBtn;
    private ImageButton backBtn;

    final Timer time = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permissions_game);



        MainModel mModel=new MainModel(getApplicationContext());
        PermissionModel pModel = mModel.getPermGameById(1);


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

        backBtn = findViewById(R.id.permission_back_btn);
        backBtn.setOnClickListener(this);


        int delay = 1000;
        int period = 1000;
        counter.setText(Integer.toString(timerSeconds));

        time.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (timerSeconds == 0) {
                    System.out.println("work finished");
                    time.cancel();
                    time.purge();
                    checkBool(camera.isChecked(), position.isChecked(), contact.isChecked(), sms.isChecked(), microphone.isChecked());
                } else {
                    setTimerSeconds();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter.setText(Integer.toString(getTimerSeconds()));
                        }
                    });
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
                    camera.getThumbDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                    camera.getTrackDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    cameraIcon.setImageResource(R.mipmap.true_icon);
                    camera.getThumbDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                    camera.getTrackDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }

        if (positionB != positionBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    positionIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    position.getThumbDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                    position.getTrackDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    positionIcon.setImageResource(R.mipmap.true_icon);
                    position.getThumbDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                    position.getTrackDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }

        if (contactB != contactBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contactIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    contact.getThumbDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                    contact.getTrackDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contactIcon.setImageResource(R.mipmap.true_icon);
                    contact.getThumbDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                    contact.getTrackDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }

        if (smsB != smsBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    smsIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    sms.getThumbDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                    sms.getTrackDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    smsIcon.setImageResource(R.mipmap.true_icon);
                    sms.getThumbDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                    sms.getTrackDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        if (microphoneB != microphoneBool) {
            gameResult = false;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    microphoneIcon.setImageResource(R.mipmap.ic_launcher_false_icon);
                    microphone.getThumbDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                    microphone.getTrackDrawable().setColorFilter(Color.rgb(250 ,25,25), PorterDuff.Mode.MULTIPLY);
                }
            });
        }
        else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    microphoneIcon.setImageResource(R.mipmap.true_icon);
                    microphone.getThumbDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
                    microphone.getTrackDrawable().setColorFilter(Color.rgb(25 ,250,25), PorterDuff.Mode.MULTIPLY);
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
                checkBool(camera.isChecked(), position.isChecked(), contact.isChecked(), sms.isChecked(), microphone.isChecked());
                break;

        }
    }

}

