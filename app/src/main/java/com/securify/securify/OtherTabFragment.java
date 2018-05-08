package com.securify.securify;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class OtherTabFragment extends Fragment {

    ImageButton settingsButton;
    ImageButton highscoresButton;
    ImageButton awardsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.other_fragment, null);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settingsButton = view.findViewById(R.id.settingsButton);
        highscoresButton = view.findViewById(R.id.highscoreButton);
        awardsButton = view.findViewById(R.id.awardsButton);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherTabFragment.this.onClick(v,"settings");
            }
        });

        highscoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherTabFragment.this.onClick(v,"highscores");
            }
        });

        awardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherTabFragment.this.onClick(v,"awards");
            }
        });
    }

    private void onClick(View v, String button_name) {
        Intent i = new Intent();
        switch(button_name){
            case "settings":
                i = new Intent(getActivity(), SettingsActivity.class);
                break;
            case "highscores":
                i = new Intent(getActivity(), HighscoresActivity.class);
                break;
            case "awards":
                i = new Intent(getActivity(), AwardsActivity.class);
                break;

                default:
                    Log.wtf("onClick", "Something went terribly wrong with a button.");
        }
        startActivity(i);
        Log.d("intent","Cannot start activity.");
    }
}
