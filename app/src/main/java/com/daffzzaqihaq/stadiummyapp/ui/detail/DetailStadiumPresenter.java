package com.daffzzaqihaq.stadiummyapp.ui.detail;

import android.content.Context;
import android.os.Bundle;

import com.daffzzaqihaq.stadiummyapp.data.local.StadiumDatabase;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;
import com.daffzzaqihaq.stadiummyapp.utils.Constant;

public class DetailStadiumPresenter implements DetailStadiumContract.Presenter {

    private final DetailStadiumContract.View view;
    private StadiumDatabase stadiumDatabase;

    public DetailStadiumPresenter(DetailStadiumContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailStadium(Bundle bundle) {
        if (bundle != null){
            StadiumItems stadiumItems = (StadiumItems) bundle.getSerializable(Constant.KEY_DATA);
            view.showDetailStadium(stadiumItems);

        }else {
            view.showFailureMessage("Data is empty");
        }

    }

    @Override
    public void addToFavorite(Context context, StadiumItems stadiumItems) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDAO().insertStadium(stadiumItems);
        view.showSuccessMessage("Saved");

    }

    @Override
    public void removeFavorite(Context context, StadiumItems stadiumItems) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDAO().delete(stadiumItems);
        view.showSuccessMessage("Deleted");

    }

    @Override
    public Boolean checkFavorite(Context context, StadiumItems stadiumItems) {
        boolean bFavorite = false;
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        return bFavorite = stadiumDatabase.stadiumDAO().selectedItem(stadiumItems.getIdTeam()) != null;
    }
}
