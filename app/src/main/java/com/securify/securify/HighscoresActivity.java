package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.userModels.UserModel;

import java.util.List;

public class HighscoresActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores_activity);

        MainModel model=new MainModel(getApplicationContext());

        List<UserModel> users=model.getTopPassword(5);

        TextView placeOne=findViewById(R.id.name1);
        TextView placeTwo=findViewById(R.id.name2);
        TextView placeThree=findViewById(R.id.name3);
        TextView placeFour=findViewById(R.id.name4);
        TextView placeFive=findViewById(R.id.name5);

        TextView points1=findViewById(R.id.points1);
        TextView points2=findViewById(R.id.points2);
        TextView points3=findViewById(R.id.points3);
        TextView points4=findViewById(R.id.points4);
        TextView points5=findViewById(R.id.points5);


        //assign name, users come already sorted from the db
        placeOne.setText(users.get(0).getName());
        placeTwo.setText(users.get(1).getName());
        placeThree.setText(users.get(2).getName());
        placeFour.setText(users.get(3).getName());
        placeFive.setText(users.get(4).getName());

        //assign highscores
        points1.setText(Long.toString(users.get(0).getPasswordHighscore()));
        points2.setText(Long.toString(users.get(1).getPasswordHighscore()));
        points3.setText(Long.toString(users.get(2).getPasswordHighscore()));
        points4.setText(Long.toString(users.get(3).getPasswordHighscore()));
        points5.setText(Long.toString(users.get(4).getPasswordHighscore()));


    }
}
