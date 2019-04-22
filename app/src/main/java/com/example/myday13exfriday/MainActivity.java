package com.example.myday13exfriday;
//Author: Mark Wessley
//Date: April 2019
//Course: CMPP 264
//Assignment: Day 13 Assignment

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

//1) created Assets folder in app import travelexperts.db file
//5) drop listview into activity.main lvAgents
public class MainActivity extends AppCompatActivity {

    private ListView lvAgents;
    private AgentDataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAgents = findViewById(R.id.lvAgents);
        source = new AgentDataSource(this);

        ArrayList list = source.getAllAgents();
        ArrayAdapter<Agent> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvAgents.setAdapter(adapter);

        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AgentUpdateActivity.class);

                intent.putExtra("agent", (Agent)lvAgents.getAdapter().getItem(position));//Agent must be serializable must cast
                startActivity(intent);
            }
        });
    }
}
