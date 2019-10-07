package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class PlayerStatsEdit extends AppCompatActivity implements OnItemSelectedListener {


//    int threes, twos, fouls, assists, rebounds;

    private DatabaseHelper db;

    private EditText name;
    private EditText number;

    private String currentPlayer;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats_edit);

        db = new DatabaseHelper(getApplicationContext());

        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);


        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        ArrayList<String> names = db.getPlayerNames();

        if(names.size() != 0) currentPlayer = names.get(0);

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

    public void AddPlayer(View view) {
        String n = name.getText().toString();
        String n2 = number.getText().toString();

        String[] stats = {n, n2, "0", "0", "0", "0", "0", "0", "0"};
        db.AddPlayer(stats);

    //update list of players
        ArrayList<String> names = db.getPlayerNames();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        currentPlayer = parent.getItemAtPosition(position).toString();
    }

    public void RemovePlayer(View view) {
        db.RemovePlayer(currentPlayer);

        //update list of players
        ArrayList<String> names = db.getPlayerNames();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
