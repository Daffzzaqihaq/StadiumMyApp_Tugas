package com.daffzzaqihaq.stadiummyapp.ui.favorite;

import android.content.Context;

import com.daffzzaqihaq.stadiummyapp.data.local.StadiumDatabase;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void searchTeams(Context context, String searchText) {
        if (!searchText.isEmpty()){
            stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);

            List<StadiumItems> stadiumItemsList = stadiumDatabase.stadiumDAO().selectFavorite();
            List<StadiumItems> mItemList = new ArrayList<>();

            if (stadiumItemsList != null){
                for (StadiumItems data: stadiumItemsList){
                    String namaStadium = data.getStrStadium().toLowerCase();
                    if (namaStadium.contains(searchText.toLowerCase())){
                        mItemList.add(data);
                    }

                    view.showDataList(mItemList);
                }
            }else {
                getDataListTeams(context);
            }
        }

    }
}
