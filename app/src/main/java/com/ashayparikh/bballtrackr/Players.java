package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Players extends AppCompatActivity {

    TextView gameNumber;

    int gameNum = 1;

    int threes, twos, fouls, assists, rebounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        gameNumber = (TextView) findViewById(R.id.gameNumber);

    }

    private void InitViews()
    {
        gameNumber.setText("Game: " + gameNum);
    }

    public void ButtonClick(View view)
    {
        switch(view.getId())
        {




        }
    }
}
