package com.securify.securify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.achievementModels.AchievementModel;

import java.util.ArrayList;
import java.util.List;

public class AwardsActivity extends AppCompatActivity implements View.OnClickListener{

    List<TextView> achTexts;
    List<ImageView> achIcons;
    List<ImageButton> achInfos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awards_activity);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //TextViews
        achTexts=new ArrayList<>();
        achTexts.add((TextView) findViewById(R.id.pwExpertText));
        achTexts.add((TextView) findViewById(R.id.pwSpecText));
        achTexts.add((TextView) findViewById(R.id.pwMasterText));
        achTexts.add((TextView) findViewById(R.id.secText));
        achTexts.add((TextView) findViewById(R.id.quickSecText));
        achTexts.add((TextView) findViewById(R.id.secExpertText));
        achTexts.add((TextView) findViewById(R.id.phiCheatText));
        achTexts.add((TextView) findViewById(R.id.phiQuickText));
        achTexts.add((TextView) findViewById(R.id.phiExpertText));

        //ImageViews
        achIcons = new ArrayList<>();
        achIcons.add((ImageView) findViewById(R.id.pwExpertIcon));
        achIcons.add((ImageView) findViewById(R.id.pwSpecIcon));
        achIcons.add((ImageView) findViewById(R.id.pwMasterIcon));
        achIcons.add((ImageView) findViewById(R.id.secIcon));
        achIcons.add((ImageView) findViewById(R.id.quickSecIcon));
        achIcons.add((ImageView) findViewById(R.id.secExpertIcon));
        achIcons.add((ImageView) findViewById(R.id.phiCheatIcon));
        achIcons.add((ImageView) findViewById(R.id.phiQuickIcon));
        achIcons.add((ImageView) findViewById(R.id.phiExpertIcon));

        //InfoButtons
        achInfos=new ArrayList<>();
        achInfos.add((ImageButton) findViewById(R.id.pwExpertInfo));
        achInfos.add((ImageButton) findViewById(R.id.pwSpecInfo));
        achInfos.add((ImageButton) findViewById(R.id.pwMasterInfo));
        achInfos.add((ImageButton) findViewById(R.id.secInfo));
        achInfos.add((ImageButton) findViewById(R.id.quickSecInfo));
        achInfos.add((ImageButton) findViewById(R.id.secExpertInfo));
        achInfos.add((ImageButton) findViewById(R.id.phiCheatInfo));
        achInfos.add((ImageButton) findViewById(R.id.phiQuickInfo));
        achInfos.add((ImageButton) findViewById(R.id.phiExpertInfo));

        for(int i=0;i<achInfos.size();++i){
            achInfos.get(i).setOnClickListener(this);
        }

    }

    @Override
    protected void onResume(){
        super.onResume();


        //get Awards from DB
        MainModel model=new MainModel(getApplicationContext());
        List<AchievementModel> awards=model.getAllAchievements();
        List<AchievementModel> awardsAchieved=model.getAchievedAchievements();

        //set Titles of Awards
        for(int i=0; i<achTexts.size();i++){
            achTexts.get(i).setText(awards.get(i).getTitle());

            //sets achieved to Black
            for(int j=0; j<awardsAchieved.size();++j) {           //cant use list.contains because database somehow returns different objects
                if(awardsAchieved.get(j).getTitle().equals(awards.get(i).getTitle())){
                    achTexts.get(i).setTextColor(Color.BLACK);

                    switch(awardsAchieved.get(j).getDifficulty()){
                        case "EASY":
                            achIcons.get(i).setImageResource(R.drawable.yellow_shield);
                            break;
                        case "MEDIUM":
                            achIcons.get(i).setImageResource(R.drawable.orange_shield);
                            break;
                        case "HARD":
                            achIcons.get(i).setImageResource(R.drawable.green_shield);
                            break;
                        default:
                            Log.e("Achievements","Error: Could not set icon.");
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        MainModel model=new MainModel(getApplicationContext());
        long awardId=0;

        switch (view.getId()){
            case R.id.pwExpertInfo:
                awardId=1;
                break;
            case R.id.pwSpecInfo:
                awardId=2;
                break;
            case R.id.pwMasterInfo:
                awardId=3;
                break;
            case R.id.secInfo:
                awardId=4;
                break;
            case R.id.quickSecInfo:
                awardId=5;
                break;
            case R.id.secExpertInfo:
                awardId=6;
                break;
            case R.id.phiCheatInfo:
                awardId=7;
                break;
            case R.id.phiQuickInfo:
                awardId=8;
                break;
            case R.id.phiExpertInfo:
                awardId=9;
                break;
            default:
                Log.e("Achievements","Could not identify clicker");
        }

        //show Achievement Info
        Snackbar infoSnackbar=Snackbar.make(view,model.getAchievement(awardId).getContext(),10000);

        //More lines so achievements wont be cut off
        View infoView=infoSnackbar.getView();
        TextView infoText=(TextView) infoView.findViewById(android.support.design.R.id.snackbar_text);
        infoText.setMaxLines(4);

        infoSnackbar.show();

    }
}
