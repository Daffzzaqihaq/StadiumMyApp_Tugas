package com.daffzzaqihaq.stadiummyapp.ui.detail;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.RequestOptions;
import com.daffzzaqihaq.stadiummyapp.R;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailStadiumActivity extends AppCompatActivity implements DetailStadiumContract.View {

    @BindView(R.id.img_logo_detail)
    ImageView imgLogoDetail;
    @BindView(R.id.txt_name_team_detail)
    TextView txtNameTeamDetail;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.card_view_detail)
    CardView cardViewDetail;
    @BindView(R.id.sv_detail)
    ScrollView svDetail;

    private Menu menu;
    private StadiumItems stadiumItems;

    private DetailStadiumPresenter detailStadiumPresenter = new DetailStadiumPresenter(this);
    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_stadium);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Detail Stadium");

        Bundle bundle = getIntent().getExtras();
        detailStadiumPresenter.getDetailStadium(bundle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.favorite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_favorite:
                if (isFavorite) {
                    detailStadiumPresenter.removeFavorite(this, stadiumItems);
                } else {
                    detailStadiumPresenter.addToFavorite(this, stadiumItems);
                }
                isFavorite = detailStadiumPresenter.checkFavorite(this, stadiumItems);
                setFavorite();
                break;

            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }

        return true;

    }

    private void setFavorite() {
        if (isFavorite){
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
    }


    @Override
    public void showDetailStadium(StadiumItems stadiumItems) {
        this.stadiumItems = stadiumItems;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        Glide.with(this).load(stadiumItems.getStrStadiumThumb()).apply(options).into(imgLogoDetail);
        txtNameTeamDetail.setText(stadiumItems.getStrStadium());
        txtDesc.setText(stadiumItems.getStrStadiumDescription());

        isFavorite = detailStadiumPresenter.checkFavorite(this, stadiumItems);

    }

    @Override
    public void showFailureMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showSuccessMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();

    }
}

