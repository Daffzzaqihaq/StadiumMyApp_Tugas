package com.daffzzaqihaq.stadiummyapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.daffzzaqihaq.stadiummyapp.R;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;
import com.daffzzaqihaq.stadiummyapp.ui.favorite.FavoriteFragment;
import com.daffzzaqihaq.stadiummyapp.ui.stadium.StadiumFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_teams:
                    getSupportActionBar().setTitle("Stadium");
                    StadiumFragment stadiumFragment = new StadiumFragment();
                    loadFragment(stadiumFragment);

                    return true;
                case R.id.navigation_favorite:
                    getSupportActionBar().setTitle("Favorite");
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    loadFragment(favoriteFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle("Stadium");

        StadiumFragment stadiumFragment = new StadiumFragment();
        loadFragment(stadiumFragment);

    }

    private void loadFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
