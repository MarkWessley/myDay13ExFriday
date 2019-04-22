package com.example.myday13exfriday;
//Author: Mark Wessley
//Date: April 2019
//Course: CMPP 264
//Assignment: Day 13 Assignment

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/* 4) Setup AgentDataSource class to call methods to update, insert, delete */
public class AgentDataSource {
    SQLiteDatabase db;
    DBHelper helper;

    public AgentDataSource( Context context) {
        helper = new DBHelper(context);
        helper.createDatabase();
        db = helper.getWritableDatabase();
        //this.db = helper.getWritableDatabase();
    }

    public Agent getAgent(int agentId) {
        //to call database using agentId
        String[]args = { agentId + "" };
        String sql = "select * from agents where AgentId=?";
        Cursor cursor = db.rawQuery(sql, args);
        cursor.moveToNext();
        return new Agent(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6),
                cursor.getInt(7));
    }

    public ArrayList<Agent> getAllAgents() {
        //setup arraylist of agent objects
        ArrayList<Agent> list = new ArrayList<>();
        Cursor cursor = (Cursor) db.rawQuery("select * from agents", null);//agents or Agents?
        while (cursor.moveToNext()) {
            list.add(new Agent(cursor.getInt(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                    cursor.getInt(7)));
            //calls agent data and sends to Agent object
        }
        return list;
    }
    //creates new agent in db
    public void insert(Agent a) {
        //call values object
        ContentValues values = new ContentValues();
        values.put("AgtFirstName", a.getAgtFirstName());
        values.put("AgtMiddleInitial", a.getAgtMiddleInitial());
        values.put("AgtLastName", a.getAgtLastName());
        values.put("AgtBusPhone", a.getAgtBusPhone());
        values.put("AgtEmail", a.getAgtEmail());
        values.put("AgtPosition", a.getAgtPosition());
        values.put("AgencyId", a.getAgencyId());
        db.insert("agents", null, values);
        //insert these values into Agents where null
    }

    //updates existing agent data
    public void update(Agent a) {
        ContentValues values = new ContentValues();
        values.put("AgtFirstName", a.getAgtFirstName());
        values.put("AgtMiddleInitial", a.getAgtMiddleInitial());
        values.put("AgtLastName", a.getAgtLastName());
        values.put("AgtBusPhone", a.getAgtBusPhone());
        values.put("AgtEmail", a.getAgtEmail());
        values.put("AgtPosition", a.getAgtPosition());
        values.put("AgencyId", a.getAgencyId());
        String where = "AgentId=?";
        String [] whereArgs = { a.getAgentId() + ""};
        db.update("Agents", values, where, whereArgs);
    }

    public void delete(int agentId){

    }
}
