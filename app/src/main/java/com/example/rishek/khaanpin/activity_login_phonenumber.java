package com.example.rishek.khaanpin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class activity_login_phonenumber extends AppCompatActivity{
    Button otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phonenumber);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        otp=findViewById(R.id.sendotp);
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_login_phonenumber.this,activity_otp_confirmation.class);
                activity_login_phonenumber.this.startActivity(intent);
                activity_login_phonenumber.this.overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
            }
        });
    }
}
