package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Context;
import android.util.Log;

public class Players extends AppCompatActivity implements OnItemSelectedListener {

    private String currentPlayer;

    private DatabaseHelper db;

    private TextView playerName;

    private TextView[] textViews = new TextView[7];

    private int teamSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        db = new DatabaseHelper(getApplicationContext());

        playerName = (TextView) findViewById(R.id.playerName);
        textViews[0] = (TextView) findViewById(R.id.t1);
        textViews[1] = (TextView) findViewById(R.id.t2);
        textViews[2] = (TextView) findViewById(R.id.t3);
        textViews[3] = (TextView) findViewById(R.id.t4);
        textViews[4] = (TextView) findViewById(R.id.t5);
        textViews[5] = (TextView) findViewById(R.id.t6);
        textViews[6] = (TextView) findViewById(R.id.t7);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        ArrayList<String> names = db.getPlayerNames();

        teamSize = names.size();

        if(teamSize != 0) currentPlayer = names.get(0);

//        Log.i("myTag", String.valueOf(names.size()));

//        Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(names.size()), Toast.LENGTH_SHORT);
//        toast.show();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    public void Update(View view) {

        if(teamSize == 0)  return;

        int[] stats = new int[7];

        for(int i = 0; i < 7; i++) {
            String value = textViews[i].getText().toString();

            int number;

            if(value.equals("")) {
                number = 0;
            } else {
                number = Integer.parseInt(value);
            }

            stats[i] = number;

            textViews[i].setText(""); //clear the textfield
        }

        db.UpdatePlayerStats(currentPlayer, stats);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        currentPlayer = parent.getItemAtPosition(position).toString();

        playerName.setText("NAME: " + currentPlayer);

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
