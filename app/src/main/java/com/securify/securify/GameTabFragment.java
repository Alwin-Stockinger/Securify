package com.securify.securify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.securify.securify.model.MainModel;

public class GameTabFragment extends Fragment{

    private int pStatus = 0;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.game_fragment, null);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton phishingButton = view.findViewById(R.id.phishingButton);
        ImageButton passwordButton = view.findViewById(R.id.passwordButton);
        ImageButton permissionsButton = view.findViewById(R.id.permissionsButton);
        final ProgressBar phishingBar = view.findViewById(R.id.phishingProgressBar);
        final ProgressBar passwordBar = view.findViewById(R.id.passwordProgressBar);
        final ProgressBar permissionsBar = view.findViewById(R.id.permissionsProgressBar);



        //Progress Bar initialization
        MainModel model=new MainModel(getContext());
        phishingBar.setProgress(model.getPhishingProgress());
        passwordBar.setProgress(model.getPassswordProgress());
        permissionsBar.setProgress(model.getPermissionProgress());


        /*
        android.view.animation.Animation an = new android.view.animation.RotateAnimation(0.0f, 90.0f, 250f, 273f);
        an.setFillAfter(true);
        phishingBar.startAnimation(an);
        passwordBar.startAnimation(an);
        permissionsBar.startAnimation(an);
        */

        /*
        //demo behaviour
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            phishingBar.setProgress(pStatus);
                            passwordBar.setProgress(pStatus);
                            permissionsBar.setProgress(pStatus);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();
        */

        phishingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String game_name = "phishing";
                GameTabFragment.this.onClick(v, game_name);
            }
        });

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String game_name = "password";
                GameTabFragment.this.onClick(v, game_name);
            }
        });

        permissionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String game_name = "permissions";
                GameTabFragment.this.onClick(v, game_name);
            }
        });
    }

    public void onClick(View v, String game_name) {
        Intent i;
        if (game_name.equals("phishing"))
            i = new Intent(getActivity(), PhishingActivity.class);
        else if (game_name.equals("password"))
            i = new Intent(getActivity(), PasswordActivity.class);
        else
            i = new Intent(getActivity(), PermissionActivity.class);
        startActivity(i);
    }

}