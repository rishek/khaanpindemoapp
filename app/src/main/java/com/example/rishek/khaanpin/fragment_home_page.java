package com.example.rishek.khaanpin;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class fragment_home_page extends Fragment {
    RecyclerView recyclerView;
    home_page_data_adapter adapter;
    ImageView chillies;
    List<home_page_data>homePageDataList;
    private Context mCtx;


    public fragment_home_page() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_page, container, false);
        recyclerView=view.findViewById(R.id.myrecyclerview);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        homePageDataList=new ArrayList<>();
        homePageDataList.add(new home_page_data("20% off Rice Combo!",R.drawable.banner1));
        homePageDataList.add(new home_page_data("New Chicken Combo!",R.drawable.banner2));
        adapter=new home_page_data_adapter(getContext(),homePageDataList);
        recyclerView.setAdapter(adapter);
        chillies=view.findViewById(R.id.chilly);
        chillies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),activity_chillies_cart.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
            }
        });
        return view;

    }

}
