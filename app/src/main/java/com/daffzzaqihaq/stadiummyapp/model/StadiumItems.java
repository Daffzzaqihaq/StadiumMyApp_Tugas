package com.daffzzaqihaq.stadiummyapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class StadiumItems implements Serializable{

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String strStadium;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String strStadiumThumb;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String strStadiumDescription;

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }
}
