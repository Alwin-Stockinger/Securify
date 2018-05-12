package com.securify.securify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.achievementModels.AchievementModel;

import java.util.ArrayList;
import java.util.List;

public class AwardsActivity extends AppCompatActivity{

    List<TextView> achTexts;


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
            for(int j=0; j<awardsAchieved.size();++j) {           //cant use list.contains because databse somehow returns different objects
                if(awardsAchieved.get(j).getTitle().equals(awards.get(i).getTitle())){
                    achTexts.get(i).setTextColor(Color.BLACK);
                }
            }
        }
    }

}
