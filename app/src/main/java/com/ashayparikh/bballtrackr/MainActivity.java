package com.ashayparikh.bballtrackr;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
    }


    public void viewAll() {
        Cursor res = db.getAllData();
        if(res.getCount() == 0) {
            //no players
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Name :"+ res.getString(0)+"\n");
            buffer.append("Number :"+ res.getString(1)+"\n");
            buffer.append("Points :"+ res.getString(2)+"\n");
            buffer.append("Assists :"+ res.getString(3)+"\n\n");
        }

    }



    //clear player data, team stats

}
