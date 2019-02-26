package com.daffzzaqihaq.stadiummyapp.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

import java.util.List;

@Dao
public interface StadiumDAO  {

    @Insert
    void insertStadium (StadiumItems stadiumItems);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    StadiumItems selectedItem (String id);

    @Delete
    void delete (StadiumItems stadiumItems);

    @Query("SELECT * FROM teams ORDER BY strStadium ASC")
    List<StadiumItems> selectFavorite();
}
