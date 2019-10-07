package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamStats extends AppCompatActivity {


    ImageView teamLogoImg;

    TextView teamName, wins, losses, players, seasons;

    String teamNameString = "Cougars";

    int winsInt = 10, lossesInt = 0, playersInt = 7, seasonsInt = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_stats);

        teamLogoImg = (ImageView) findViewById(R.id.teamLogo2);
        teamName = (TextView) findViewById(R.id.playerName);
        wins = (TextView) findViewById(R.id.stat1);
        losses = (TextView) findViewById(R.id.stat2);
        players = (TextView) findViewById(R.id.stat3);
        seasons = (TextView) findViewById(R.id.stat4);

        InitViews();

    }


    private void InitViews()
    {
        //teamLogoImg.setImageResource(TEAMLOGO);
        teamName.setText(teamNameString);
        wins.setText("Wins: " + winsInt);
        losses.setText("Losses: " + lossesInt);
        players.setText("Players: " + playersInt);
        seasons.setText("Seasons: " + seasonsInt);
    }

    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
