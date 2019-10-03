package com.ashayparikh.bballtrackr;

import java.io.FileOutputStream;
import java.io.File;
import android.content.Context;

public class Data {

//https://www.journaldev.com/9383/android-internal-storage-example-tutorial

    public Data(String filename) {

    }

    //creates a file
    public static void CreateFile(String filename, Context context) {
        FileOutputStream fOut = context.openFileOutput(filename, Context.MODE_PRIVATE);
    }

    //checks if a file exists
    public boolean FileExists(String filepath) {
        File file = new File(filepath);
        return file.exists();
    }

    //returns a string containing the data of a player
    public String getPlayerData(int player) {

    }

    //parses the text file, returns all data in string format
    public String getData() {

    }

    //adds a player to the team
    public void AddPlayer() {

    }

    //modify stats of a certain player
    public void ModifyPlaterStats(int[] data) {

    }

}
