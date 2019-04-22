package com.example.myday13exfriday;
//Author: Mark Wessley
//Date: April 2019
//Course: CMPP 264
//Assignment: Day 13 Assignment

import java.io.Serializable;
//3) create Agent Class with constructors, getters/setters and toString methods
public class Agent implements Serializable {
    private int AgentId;//0
    private String AgtFirstName;//1
    private String AgtMiddleInitial;//2
    private String AgtLastName;//3
    private String AgtBusPhone;//4
    private String AgtEmail;//5
    private String AgtPosition;//6
    private int AgencyId;//7

    //generate constructor
    public Agent (int agentId, String agtFirstName, String agtMiddleInitial, String agtLastName, String agtBusPhone, String agtEmail, String agtPosition, int agencyId) {
        AgentId = agentId;
        AgtFirstName = agtFirstName;
        AgtMiddleInitial = agtMiddleInitial;
        AgtLastName = agtLastName;
        AgtBusPhone = agtBusPhone;
        AgtEmail = agtEmail;
        AgtPosition = agtPosition;
        AgencyId = agencyId;

    }
    //generate getters and setters


    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }

    public String getAgtFirstName() {
        return AgtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        AgtFirstName = agtFirstName;
    }

    public String getAgtMiddleInitial() {
        return AgtMiddleInitial;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        AgtMiddleInitial = agtMiddleInitial;
    }

    public String getAgtLastName() {
        return AgtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        AgtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return AgtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        AgtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return AgtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        AgtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return AgtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        AgtPosition = agtPosition;
    }

    public int getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(int agencyId) {
        AgencyId = agencyId;
    }

    //generate toString() methods
    @Override
    public String toString() {
        return "Agent Id: " + AgentId +
                "\nFirst Name: " + AgtFirstName +
                "\nLast Name: " + AgtLastName + "\n";
    }
}
