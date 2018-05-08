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
        ImageButton phishingButton = view.findViewById(R.id.phishingButton);
        ImageButton passwordButton = view.findViewById(R.id.passwordButton);
        ImageButton permissionsButton = view.findViewById(R.id.permissionsButton);
        ProgressBar phishingBar = view.findViewById(R.id.phishingProgressBar);
        ProgressBar passwordBar = view.findViewById(R.id.passwordProgressBar);
        ProgressBar permissionsBar = view.findViewById(R.id.permissionsProgressBar);
    }

}