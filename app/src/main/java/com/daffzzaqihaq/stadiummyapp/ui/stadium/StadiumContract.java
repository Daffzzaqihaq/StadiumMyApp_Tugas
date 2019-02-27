package com.daffzzaqihaq.stadiummyapp.ui.stadium;

import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

import java.util.List;

public interface StadiumContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<StadiumItems> stadiumItemsList);
        void showFaillureMessage(String msg);
    }

    interface Presenter{
        void getDataListStadium();
        void getSearchStadium(String searchText);
    }
}
