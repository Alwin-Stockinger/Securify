package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.achievementModels.AchievementModel;

import java.util.List;

public class AwardsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awards_activity);

        //get Awards from DB
        MainModel model=new MainModel(getApplicationContext());
        List<AchievementModel> awards=model.getAllAchievements();

        //TextViews
        TextView ach1Text=findViewById(R.id.pwExpertText);
        TextView ach2Text=findViewById(R.id.pwSpecText);
        TextView ach3Text=findViewById(R.id.pwMasterText);
        TextView ach4Text=findViewById(R.id.secText);
        TextView ach5Text=findViewById(R.id.secExpertText);
        TextView ach6Text=findViewById(R.id.quickSecText);


        //set Titles of Awards
        ach1Text.setText(awards.get(0).getTitle());
        ach2Text.setText(awards.get(1).getTitle());
        ach3Text.setText(awards.get(2).getTitle());
        ach4Text.setText(awards.get(3).getTitle());
        ach5Text.setText(awards.get(4).getTitle());
        ach6Text.setText(awards.get(5).getTitle());

    }
}
