package com.securify.securify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.securify.securify.model.MainModel;
import com.securify.securify.model.userModels.UserModel;

import java.util.List;

public class HighscoresActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores_activity);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        MainModel model=new MainModel(getApplicationContext());

        List<UserModel> users = model.getTopPassword(5);
        List<UserModel> phishing_scores = model.getTopPhishing(5);
        List<UserModel> permissions_scores = model.getTopPermission(5);

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

        TextView pl1phish = findViewById(R.id.name1_phishing);
        TextView pl2phish = findViewById(R.id.name2_phishing);
        TextView pl3phish = findViewById(R.id.name3_phishing);
        TextView pl4phish = findViewById(R.id.name4_phishing);
        TextView pl5phish = findViewById(R.id.name5_phishing);

        TextView pts1phish = findViewById(R.id.points1_phishing);
        TextView pts2phish = findViewById(R.id.points2_phishing);
        TextView pts3phish = findViewById(R.id.points3_phishing);
        TextView pts4phish = findViewById(R.id.points4_phishing);
        TextView pts5phish = findViewById(R.id.points5_phishing);

        TextView pl1perm = findViewById(R.id.name1_permissions);
        TextView pl2perm = findViewById(R.id.name2_permissions);
        TextView pl3perm = findViewById(R.id.name3_permissions);
        TextView pl4perm = findViewById(R.id.name4_permissions);
        TextView pl5perm = findViewById(R.id.name5_permissions);

        TextView pts1perm = findViewById(R.id.points1_permissions);
        TextView pts2perm = findViewById(R.id.points2_permissions);
        TextView pts3perm = findViewById(R.id.points3_permissions);
        TextView pts4perm = findViewById(R.id.points4_permissions);
        TextView pts5perm = findViewById(R.id.points5_permissions);

        //assign name, users come already sorted from the db
        placeOne.setText(users.get(0).getName());
        placeTwo.setText(users.get(1).getName());
        placeThree.setText(users.get(2).getName());
        placeFour.setText(users.get(3).getName());
        placeFive.setText(users.get(4).getName());

        pl1phish.setText(phishing_scores.get(0).getName());
        pl2phish.setText(phishing_scores.get(1).getName());
        pl3phish.setText(phishing_scores.get(2).getName());
        pl4phish.setText(phishing_scores.get(3).getName());
        pl5phish.setText(phishing_scores.get(4).getName());

        pl1perm.setText(permissions_scores.get(0).getName());
        pl2perm.setText(permissions_scores.get(1).getName());
        pl3perm.setText(permissions_scores.get(2).getName());
        pl4perm.setText(permissions_scores.get(3).getName());
        pl5perm.setText(permissions_scores.get(4).getName());

        //assign highscores
        points1.setText(Long.toString(users.get(0).getPasswordHighscore()));
        points2.setText(Long.toString(users.get(1).getPasswordHighscore()));
        points3.setText(Long.toString(users.get(2).getPasswordHighscore()));
        points4.setText(Long.toString(users.get(3).getPasswordHighscore()));
        points5.setText(Long.toString(users.get(4).getPasswordHighscore()));

        pts1phish.setText(Long.toString(phishing_scores.get(0).getPhishingHighscore()));
        pts2phish.setText(Long.toString(phishing_scores.get(1).getPhishingHighscore()));
        pts3phish.setText(Long.toString(phishing_scores.get(2).getPhishingHighscore()));
        pts4phish.setText(Long.toString(phishing_scores.get(3).getPhishingHighscore()));
        pts5phish.setText(Long.toString(phishing_scores.get(4).getPhishingHighscore()));

        pts1perm.setText(Long.toString(permissions_scores.get(0).getPermissionHighscore()));
        pts2perm.setText(Long.toString(permissions_scores.get(1).getPermissionHighscore()));
        pts3perm.setText(Long.toString(permissions_scores.get(2).getPermissionHighscore()));
        pts4perm.setText(Long.toString(permissions_scores.get(3).getPermissionHighscore()));
        pts5perm.setText(Long.toString(permissions_scores.get(4).getPermissionHighscore()));
    }
}
