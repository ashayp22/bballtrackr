package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView coachName, teamName;

    ImageView teamLogo;

    //Arraylist players that will be appended to the players dropdown

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coachName = (TextView) findViewById(R.id.coachName);
        teamName = (TextView) findViewById(R.id.teamName);

        teamLogo = (ImageView) findViewById(R.id.teamLogo);
    }

    public void NewGame(View view)
    {

    }

    public void ViewStats(View view)
    {

    }

    public void Teams(View view)
    {

    }

    public void ManagePlayers(View view)
    {

    }

}
