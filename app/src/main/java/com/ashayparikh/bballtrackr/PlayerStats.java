package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

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

public class PlayerStats extends AppCompatActivity implements OnItemSelectedListener {


    TextView pName, s1, s2, s3, s4, s5, s6, s7;


    String playername;

    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats);

        db = new DatabaseHelper(getApplicationContext());

        pName = (TextView) findViewById(R.id.playerName);

        s1 = (TextView) findViewById(R.id.stat1);
        s2 = (TextView) findViewById(R.id.stat2);
        s3 = (TextView) findViewById(R.id.stat3);
        s4 = (TextView) findViewById(R.id.stat4);
        s5 = (TextView) findViewById(R.id.stat5);
        s6 =(TextView) findViewById(R.id.stat6);
        s7 = (TextView) findViewById(R.id.stat7);


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        ArrayList<String> names = db.getPlayerNames();

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

    private void InitViews()
    {
        pName.setText(playername);

        s1.setText("POINTS");
        s2.setText("ASSISTS");
        s3.setText("REBOUNDS");
        s4.setText("STEALS");
        s5.setText("BLOCKS");
        s6.setText("TURNOVERS");
        s7.setText("MINUTES");

        //picture.setImageResource(IMAGE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String name = parent.getItemAtPosition(position).toString();

        //display stats now

        String[] stats = db.getPlayerData(name);

        pName.setText(name + " #" + stats[1]);

        s1.setText("POINT: " + stats[2]);
        s2.setText("ASSISTS: " + stats[3]);
        s3.setText("REBOUNDS: " + stats[4]);
        s4.setText("STEALS: " + stats[5]);
        s5.setText("BLOCKS: " + stats[6]);
        s6.setText("TURNOVERS: " + stats[7]);
        s7.setText("MINUTES: " + stats[8]);


        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //function that will change player with the spinenr object
}
