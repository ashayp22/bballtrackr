package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class PlayerStatsEdit extends AppCompatActivity {


//    int threes, twos, fouls, assists, rebounds;

    private DatabaseHelper db;

    private EditText name;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats_edit);

        db = new DatabaseHelper(getApplicationContext());

        name = (EditText) findViewById(R.id.number);
        number = (EditText) findViewById(R.id.number);
    }

    public void AddPlayer(View view) {
        String n = name.getText().toString();
        String n2 = number.getText().toString();

        String[] stats = {n, n2, "0", "0", "0", "0", "0", "0", "0"};

        db.AddPlayer(stats);
        Toast toast = Toast.makeText(getApplicationContext(), Boolean.toString(db.AddPlayer(stats)), Toast.LENGTH_SHORT);
        toast.show();
    }




//    public void ButtonClick(View view)
//    {
//        switch(view.getId())
//        {
//            case R.id.stat__1: twos++; break;
//            case R.id.stat_1: twos--; break;
//
//            case R.id.butPos2: threes++; break;
//            case R.id.stat_: threes--; break;
//
//            case R.id.stat__2: rebounds++; break;
//            case R.id.stat_2: rebounds--; break;
//
//            case R.id.stat__3: fouls++; break;
//            case R.id.stat_3: fouls--; break;
//
//            case R.id.stat__4: assists++; break;
//            case R.id.stat_4: assists--; break;
//
//            //case R.id.nextButton: SWITCH PLAYER; break;
//
//        }
//    }

    public void GoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
