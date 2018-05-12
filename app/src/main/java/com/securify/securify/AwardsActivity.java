package com.securify.securify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.achievementModels.AchievementModel;

import java.util.ArrayList;
import java.util.List;

public class AwardsActivity extends AppCompatActivity{

    List<TextView> achTexts;
    List<ImageView> achIcons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awards_activity);



        //TextViews
        achTexts=new ArrayList<>();
        achTexts.add((TextView) findViewById(R.id.pwExpertText));
        achTexts.add((TextView) findViewById(R.id.pwSpecText));
        achTexts.add((TextView) findViewById(R.id.pwMasterText));
        achTexts.add((TextView) findViewById(R.id.secText));
        achTexts.add((TextView) findViewById(R.id.quickSecText));
        achTexts.add((TextView) findViewById(R.id.secExpertText));

        //ImageViews
        achIcons = new ArrayList<>();
        achIcons.add((ImageView) findViewById(R.id.pwExpertIcon));
        achIcons.add((ImageView) findViewById(R.id.pwSpecIcon));
        achIcons.add((ImageView) findViewById(R.id.pwMasterIcon));
        achIcons.add((ImageView) findViewById(R.id.secIcon));
        achIcons.add((ImageView) findViewById(R.id.quickSecIcon));
        achIcons.add((ImageView) findViewById(R.id.secExpertIcon));

        //InfoButtons
        //when clicked shows context in a message?
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
                            Log.d("Achievements","Error: Could not set icon.");
                    }
                }
            }
        }
    }

}
