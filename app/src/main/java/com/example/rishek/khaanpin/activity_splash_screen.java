package com.example.rishek.khaanpin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.WindowManager;

public class activity_splash_screen extends Activity {

    private final int SPLASH_DISPLAY_LENGTH=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent=new Intent(activity_splash_screen.this,MainActivity.class);
                activity_splash_screen.this.startActivity(mainIntent);
                activity_splash_screen.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}

