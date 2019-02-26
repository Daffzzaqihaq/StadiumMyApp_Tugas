package com.daffzzaqihaq.stadiummyapp.ui.favorite;

import android.content.Context;

import com.daffzzaqihaq.stadiummyapp.data.local.StadiumDatabase;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private FavoriteContract.View view;
    private StadiumDatabase stadiumDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        if (stadiumDatabase.stadiumDAO().selectFavorite() != null){
            view.showDataList(stadiumDatabase.stadiumDAO().selectFavorite());

        }else {
            view.showFailureMessage("Your Favorite list is empty");
        }
        view.hideRefresh();



    }
}
