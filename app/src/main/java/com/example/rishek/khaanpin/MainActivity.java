package com.example.rishek.khaanpin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button phonenumberlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        phonenumberlogin=findViewById(R.id.loginphonenumber);
        phonenumberlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,activity_login_phonenumber.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

            }
        });
    }
}
