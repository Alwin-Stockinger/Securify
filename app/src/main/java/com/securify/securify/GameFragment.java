package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class GameFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.game_fragment, null);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton phishingButton = view.findViewById(R.id.phishing_game_text);
        ImageButton passwordButton = view.findViewById(R.id.password_game_text);
        ImageButton permissionsButton = view.findViewById(R.id.permissions_game_text);
        ProgressBar phishingBar = view.findViewById(R.id.permissionsProgressBar);
        ProgressBar passwordBar = view.findViewById(R.id.passwordProgressBar);
        ProgressBar permissionsBar = view.findViewById(R.id.permissionsProgressBar);
    }

    @Override
    public String toString() {
        return "GameTest";
    }
}