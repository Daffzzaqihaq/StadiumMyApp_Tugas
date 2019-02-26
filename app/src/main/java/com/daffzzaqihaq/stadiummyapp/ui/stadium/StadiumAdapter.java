package com.daffzzaqihaq.stadiummyapp.ui.stadium;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daffzzaqihaq.stadiummyapp.R;
import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;
import com.daffzzaqihaq.stadiummyapp.ui.detail.DetailStadiumActivity;
import com.daffzzaqihaq.stadiummyapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder> {


    private Context context;
    private List<StadiumItems> stadiumItemsList;

    public StadiumAdapter(Context context, List<StadiumItems> stadiumItemsList) {
        this.context = context;
        this.stadiumItemsList = stadiumItemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_stadium, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final StadiumItems stadiumItems = stadiumItemsList.get(i);

        final RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        Glide.with(context).load(stadiumItems.getStrStadiumThumb()).apply(options).into(viewHolder.imgLogoTeam);
        viewHolder.txtNameTeam.setText(stadiumItems.getStrStadium());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailStadiumActivity.class).putExtra(Constant.KEY_DATA, stadiumItems));
            }
        });

    }

    @Override
    public int getItemCount() {
        return stadiumItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
