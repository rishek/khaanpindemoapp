package com.example.rishek.khaanpin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class home_page_data_adapter extends RecyclerView.Adapter<home_page_data_adapter.HomePageDataViewHolder> {
    private Context mCtx;
    private List<home_page_data>home_page_dataList;

 public home_page_data_adapter(Context mCtx,List<home_page_data>home_page_dataList)
 {
     this.mCtx = mCtx;
     this.home_page_dataList = home_page_dataList;
 }
    @Override
    public HomePageDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recyclerview_elements_homepage, null);
        return new HomePageDataViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull HomePageDataViewHolder homePageDataViewHolder, int i) {
        home_page_data homePagData = home_page_dataList.get(i);
        homePageDataViewHolder.offers.setText(homePagData.getText());
        homePageDataViewHolder.banner.setImageDrawable(mCtx.getResources().getDrawable(homePagData.getImage()));
    }

    @Override
    public int getItemCount() {
        return home_page_dataList.size();
    }

    public class HomePageDataViewHolder extends RecyclerView.ViewHolder {
        ImageView banner;
        TextView offers;
        public HomePageDataViewHolder(@NonNull View itemView) {
            super(itemView);
            offers=itemView.findViewById(R.id.id_offer);
            banner=itemView.findViewById(R.id.id_banner);
        }
    }
}
