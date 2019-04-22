package com.example.myday13exfriday;
//Author: Mark Wessley
//Date: April 2019
//Course: CMPP 264
//Assignment: Day 13 Assignment

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.renderscript.ScriptGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//2) create DBHelper class
//4) complete class with constructors and methods


public class DBHelper extends SQLiteOpenHelper {
    private static String name = "TravelExpertsSqlLite.db";
    private static String path = "/data/data/com.example.myday13exfriday/databases/";
    //linux filepath from package above which contains database file
    private final Context myContext;
    private SQLiteDatabase myDatabase;

    //generate constructor using context, db name=string, cursor=null, version number=1)?  used extends SQLiteHelper instead?
    public DBHelper(Context context) {
        //super(context, name, factory, version)
        super(context, name, null, 1);
        this.myContext = context;
        //above done to set up reference
    }

    public void createDatabase()
        /* will call to see if database exists if not it will create db from db file asset folder */
    {
        if (dbExists())
        {
            //do nothing
            System.out.println("db exists");
        }
        else
        {
            copyDatabase();
            System.out.println("db created");
        }
    }

    public void copyDatabase() {
        try {
            //to get to file using constructor argument
            InputStream myInput = myContext.getAssets().open(name);
            //from superclass SQLiteOpenHelper class
            OutputStream myOutput = new FileOutputStream(path + name);

            byte[] buffer = new byte[1024];//reads byte array and sends it out to output
            int length;  //to know how many bytes were read and written
            //call input and read byte array and return values
            while ((length = myInput.read(buffer)) > 0) {
                //can read/write
                myOutput.write(buffer, 0, length);//name of array, start at 0, write #of bytes(length)
            }

            myOutput.flush();//clears buffer
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error IO Exception when copying database");
        }
    }
    //checks if db exists
    private boolean dbExists() {
        File dbFile = new File(path + name);
        if (dbFile.exists()) {
            Log.d("mark", "database file found");
            return true;
        }
        else
        {
            Log.d("mark", "database file not found");
            return false;
        }


    }

    //to open read and write the database
    public void openDatabase()
    {
        myDatabase = SQLiteDatabase.openDatabase(path + name, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

/* has overrides for onCreate and onUpgrade but no content */
