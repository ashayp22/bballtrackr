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

    String coachNameT = "Cortez";
    String teamNameT = "Cougars";

    TextView coachName, teamName;

    //Arraylist players that will be appended to the players dropdown
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        //clear player data, team stats
        coachName = (TextView)findViewById(R.id.coachName);
        teamName = (TextView)findViewById(R.id.teamName);

        InitViews();
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


    private void InitViews()
    {
        coachName.setText("Coach " + coachNameT);
        teamName.setText("Team " + teamNameT);

        //teamLogo.setImageResource(IMAGE);
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

    public void Teams(View view)
    {
        Intent intent = new Intent(this, TeamStats.class);
        startActivity(intent);
    }

    public void ManagePlayers(View view)
    {
        Intent intent = new Intent(this, PlayerStatsEdit.class);
        startActivity(intent);
    }

}
