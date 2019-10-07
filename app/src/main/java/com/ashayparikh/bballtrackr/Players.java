package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            case R.id.stat__1: twos++; break;
            case R.id.stat_1: twos--; break;

            case R.id.butPos2: threes++; break;
            case R.id.stat_: threes--; break;

            case R.id.stat__2: rebounds++; break;
            case R.id.stat_2: rebounds--; break;

            case R.id.stat__3: fouls++; break;
            case R.id.stat_3: fouls--; break;

            case R.id.stat__4: assists++; break;
            case R.id.stat_4: assists--; break;

            //case R.id.nextButton: SWITCH PLAYER; break;

        }
    }

    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
