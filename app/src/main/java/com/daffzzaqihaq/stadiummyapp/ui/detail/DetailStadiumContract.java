package com.daffzzaqihaq.stadiummyapp.ui.detail;

import android.content.Context;
import android.os.Bundle;

import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

public interface DetailStadiumContract {

    interface View{
        void showDetailStadium(StadiumItems stadiumItems);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface Presenter{
        void getDetailStadium(Bundle bundle);
        void addToFavorite(Context context, StadiumItems stadiumItems);
        void removeFavorite(Context context, StadiumItems stadiumItems);
        Boolean checkFavorite(Context context, StadiumItems stadiumItems);
    }
}
