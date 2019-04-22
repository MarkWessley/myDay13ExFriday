package com.example.myday13exfriday;
//Author: Mark Wessley
//Date: April 2019
//Course: CMPP 264
//Assignment: Day 13 Assignment

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgentUpdateActivity extends AppCompatActivity {
    EditText etAgentId, etAgtFirstName, etAgtMiddleInitial, etAgtLastName, etAgtBusPhone, etAgtEmail, etAgtPosition, etAgencyId;
    Button btnSave;
    AgentDataSource source;
    //AgentDataSource source = new AgentDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_update);

        source = new AgentDataSource(this);//added
        source.helper.openDatabase();//calls helper from AgentDataSource

        etAgentId = findViewById(R.id.etAgentId);
        etAgtFirstName = findViewById(R.id.etAgtFirstName);
        etAgtMiddleInitial = findViewById(R.id.etAgtMiddleInitial);
        etAgtLastName = findViewById(R.id.etAgtLastName);
        etAgtBusPhone = findViewById(R.id.etAgtBusPhone);
        etAgtEmail = findViewById(R.id.etAgtEmail);
        etAgtPosition = findViewById(R.id.etAgtPosition);
        etAgencyId = findViewById(R.id.etAgencyId);

        Agent a = (Agent) getIntent().getSerializableExtra("agent");//added
        //final Agent a = (Agent) getIntent().getSerializableExtra("agent");
        etAgentId.setText(a.getAgentId() + "");
        etAgtFirstName.setText(a.getAgtFirstName());
        etAgtMiddleInitial.setText(a.getAgtMiddleInitial());
        etAgtLastName.setText(a.getAgtLastName());
        etAgtBusPhone.setText(a.getAgtBusPhone());
        etAgtEmail.setText(a.getAgtEmail());
        etAgtPosition.setText(a.getAgtPosition());
        etAgencyId.setText(a.getAgencyId() + "");

        //add a click listener to the button to call the datasource update method
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agent agt = new Agent(Integer.parseInt(etAgentId.getText().toString()),
                        etAgtFirstName.getText().toString(),
                        etAgtMiddleInitial.getText().toString(),
                        etAgtLastName.getText().toString(),
                        etAgtBusPhone.getText().toString(),
                        etAgtEmail.getText().toString(),
                        etAgtPosition.getText().toString(),
                        Integer.parseInt(etAgentId.getText().toString()));
                source.update(agt);
            }
        });
    }
}
