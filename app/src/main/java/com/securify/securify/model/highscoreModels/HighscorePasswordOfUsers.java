package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.Embedded;

/**
 * Created by Alwin on 07.05.2018.
 */

public class HighscorePasswordOfUsers extends HighscoreOfUsers {
    @Embedded
    HighscorePasswordModel highscorePasswordModel;
}
