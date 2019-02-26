package com.daffzzaqihaq.stadiummyapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StadiumResponse {

    @SerializedName("teams")
    private List<StadiumItems> teams;

    public List<StadiumItems> getTeams() {
        return teams;
    }

    public void setTeams(List<StadiumItems> teams) {
        this.teams = teams;
    }
}



