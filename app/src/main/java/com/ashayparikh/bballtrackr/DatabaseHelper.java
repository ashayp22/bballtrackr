package com.ashayparikh.bballtrackr;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    //http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/

    public static final String DATABASE_NAME = "data.db";
    public static final String TABLE_NAME = "team_stats";

    private static final String[] COLS = {"NAME", "NUMBER", "POINTS", "ASSISTS", "REBOUNDS", "STEALS", "BLOCKS", "TURNOVERS", "MINUTES"};


    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    //implemented methods
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //add a new player
    public boolean AddPlayer(String[] data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int i = 0;
        for (String s : COLS) {
            contentValues.put(s,data[i]);
            i++;
        }
        long result = db.insert(TABLE_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }


    //get all the data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public ArrayList<String> getPlayerNames() {
        Cursor allData = getAllData();

        ArrayList<String> names = new ArrayList<>();

        while(allData.moveToNext()) {
            names.add(allData.getString(0));
        }

        return names;
    }

    //get the data of a certain player
    public String[] getPlayerData(String playerName) {
        Cursor allData = getAllData();

        String[] s = new String[9];

        while(allData.moveToNext()) {
            if(allData.getString(0).equals(playerName)) { //found the player
                for(int i =0 ; i < 9; i++) {
                    s[i] = allData.getString(i);
                }
            }
        }
        return s;
    }

    //add onto a players stats
    public void UpdatePlayerStats(String playerName, int[] stats) { //passed in the numbers for the players most recent game, starting with points
        String[] data = getPlayerData(playerName);

        for(int i = 2; i < 9; i++) {
            data[i] = String.valueOf(Integer.parseInt(data[i]) + stats[i-2]);
        }

        UpdateTable(data);
    }


    //update a players data
    public boolean UpdateTable(String[] data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int i = 0;
        for (String s : COLS) {
            contentValues.put(s,data[i]);
            i++;
        }
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { data[0] });
        return true;
    }


    //delete a player
    public Integer RemovePlayer (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {name});
    }

}
