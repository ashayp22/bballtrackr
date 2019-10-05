package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerStats extends AppCompatActivity {


    TextView pName, s1, s2, s3, s4, s5;


    ImageView picture;

    String playername;
    int threes, twos, fouls, assists, rebounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats);

        picture = (ImageView) findViewById(R.id.teamLogo);

        pName = (TextView) findViewById(R.id.playerName);

        s1 = (TextView) findViewById(R.id.stat1);
        s2 = (TextView) findViewById(R.id.stat2);
        s3 = (TextView) findViewById(R.id.stat3);
        s4 = (TextView) findViewById(R.id.stat4);
        s5 = (TextView) findViewById(R.id.stat5);

    }

    private void InitViews()
    {
        pName.setText(playername);

        s1.setText("3S: " + threes);
        s2.setText("2S: " + twos);
        s3.setText("Fouls: " + fouls);
        s4.setText("Assists: " + assists);
        s5.setText("Rebounds: " + rebounds);

        //picture.setImageResource(IMAGE);
    }

    //function that will change player with the spinenr object
}
