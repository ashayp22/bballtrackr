package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Players extends AppCompatActivity {

    TextView gameNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        gameNumber = (TextView) findViewById(R.id.gameNumber);

    }
}
