package com.daffzzaqihaq.stadiummyapp.data.remote;

import com.daffzzaqihaq.stadiummyapp.model.StadiumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<StadiumResponse> getStadium(
            @Query("s") String s,
            @Query("c") String c
    );

    @GET("/api/v1/json/1/lookupteam.php")
    Call<StadiumResponse> getDetail(
            @Query("id") int id
    );
}
