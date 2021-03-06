package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;



//Game - add stats for the game
//View Stats - see all the players stats
//Team - team stats
//Player Stats Edit - change player stats, remove and add a player

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db;

    //Arraylist players that will be appended to the players dropdown
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
    }


    public void viewAll() {
        Cursor res = db.getAllData();
        if(res.getCount() == 0) {
            //no players
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Name :"+ res.getString(0)+"\n");
            buffer.append("Number :"+ res.getString(1)+"\n");
            buffer.append("Points :"+ res.getString(2)+"\n");
            buffer.append("Assists :"+ res.getString(3)+"\n\n");
        }

    }


    public void NewGame(View view)
    {
        Intent intent = new Intent(this, Players.class);
        startActivity(intent);

    }

    public void ViewStats(View view)
    {
        Intent intent = new Intent(this, PlayerStats.class);
        startActivity(intent);
    }

    public void ManagePlayers(View view)
    {
        Intent intent = new Intent(this, PlayerStatsEdit.class);
        startActivity(intent);
    }


    //adding: better ui (make text in proper spot, change background); clear a persons stats; team stats(number of games, wins, losses)

}
