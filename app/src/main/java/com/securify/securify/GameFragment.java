package com.securify.securify;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class GameFragment extends Fragment {

    private int pStatus = 0;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, null);
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

    }

    public void onClick(View v){

    }


    @Override
    public String toString() {
        return "GameTest";
    }

}