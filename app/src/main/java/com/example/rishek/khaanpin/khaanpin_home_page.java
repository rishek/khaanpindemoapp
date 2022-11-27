package com.example.rishek.khaanpin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class khaanpin_home_page extends AppCompatActivity {
    Dialog khaanpinquest;
    ImageView tickbuttn1;
    ImageView tickbuttn2;
    Button proceed;
    private BottomNavigationView nav_bar;
    private fragment_snacks snacks_fragment;
    private fragment_dinner dinner_fragment;
    private fragment_drinks drinks_fragment;
    private fragment_extras extras_fragment;
    private fragment_home_page home_page_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khaanpin_home_page);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        khaanpinquest = new Dialog(this);
        showkhaanpinquest();
        snacks_fragment=new fragment_snacks();
        dinner_fragment=new fragment_dinner();
        drinks_fragment = new fragment_drinks();
        extras_fragment = new fragment_extras();
        home_page_fragment = new fragment_home_page();
        nav_bar = findViewById(R.id.nav_bar);
        nav_bar.setSelectedItemId(R.id.homepage);
        setFragment(home_page_fragment);
        nav_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.snacks:
                        setFragment(snacks_fragment);
                        break;
                    case R.id.dinner:
                        setFragment(dinner_fragment);
                        break;
                    case R.id.homepage:
                        setFragment(home_page_fragment);
                        break;
                    case R.id.drinks:
                        setFragment(drinks_fragment);
                        break;
                    case R.id.extras:
                        setFragment(extras_fragment);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void showkhaanpinquest() {
        khaanpinquest.setContentView(R.layout.khaanpin_quest_popup);
        khaanpinquest.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        khaanpinquest.show();
        tickbuttn1 = khaanpinquest.findViewById(R.id.fillcolor1);
        tickbuttn2 = khaanpinquest.findViewById(R.id.fillcolor2);
        proceed=khaanpinquest.findViewById(R.id.contnue);
        tickbuttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickbuttn1.setImageDrawable(getResources().getDrawable(R.drawable.filledcircle));

            }
        });
        tickbuttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickbuttn2.setImageDrawable(getResources().getDrawable(R.drawable.filledcircle));
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khaanpinquest.dismiss();
            }
            });
        khaanpinquest.setCanceledOnTouchOutside(false);
    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
