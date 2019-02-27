package com.daffzzaqihaq.stadiummyapp.ui.favorite;

import android.content.Context;

import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataList(List<StadiumItems> stadiumItemsList);
        void showFailureMessage(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getDataListTeams(Context context);
        void searchTeams(Context context, String searchText);
    }
}
