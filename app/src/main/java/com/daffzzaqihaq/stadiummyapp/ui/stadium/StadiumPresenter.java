package com.daffzzaqihaq.stadiummyapp.ui.stadium;

import android.telecom.Call;

import com.daffzzaqihaq.stadiummyapp.data.remote.ApiClient;
import com.daffzzaqihaq.stadiummyapp.data.remote.ApiInterface;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;
import com.daffzzaqihaq.stadiummyapp.model.StadiumResponse;
import com.daffzzaqihaq.stadiummyapp.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class StadiumPresenter implements StadiumContract.Presenter{

    private final StadiumContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public StadiumPresenter(StadiumContract.View view) {
        this.view = view;
    }


    @Override
    public void getDataListStadium() {
        view.showProgress();

        retrofit2.Call<StadiumResponse> call = apiInterface.getStadium(Constant.s, Constant.c);
        call.enqueue(new Callback<StadiumResponse>() {
            @Override
            public void onResponse(retrofit2.Call<StadiumResponse> call, Response<StadiumResponse> response) {
                view.hideProgress();

                if (response.body() != null){
                    view.showDataList(response.body().getTeams());

                }else {
                    view.showFaillureMessage("Data is empty");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<StadiumResponse> call, Throwable t) {
                view.hideProgress();
                view.showFaillureMessage(t.getMessage());


            }
        });
    }

    @Override
    public void getSearchStadium(final String searchText) {
        if (!searchText.isEmpty()){
            view.showProgress();
            retrofit2.Call<StadiumResponse> call = apiInterface.getStadium(Constant.s, Constant.c);
            call.enqueue(new Callback<StadiumResponse>() {
                @Override
                public void onResponse(retrofit2.Call<StadiumResponse> call, Response<StadiumResponse> response) {
                    view.hideProgress();

                    if (response.body() != null){
                        List<StadiumItems> stadiumItemsList = response.body().getTeams();
                        List<StadiumItems> mStadiumItemsList = new ArrayList<>();

                        for (StadiumItems data: stadiumItemsList){
                            String namaStd = data.getStrStadium().toLowerCase();
                            if (namaStd.contains(searchText.toLowerCase())){
                                mStadiumItemsList.add(data);
                            }
                        }
                        view.showDataList(mStadiumItemsList);
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<StadiumResponse> call, Throwable t) {
                    view.hideProgress();
                    view.showFaillureMessage(t.getMessage());
                }
            });
        }else {
            getDataListStadium();
        }

    }
}
