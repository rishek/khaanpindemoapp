package com.example.rishek.khaanpin;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class activity_otp_confirmation extends AppCompatActivity implements TextWatcher {
    EditText otp_one;
    EditText otp_two;
    EditText otp_three;
    EditText otp_four;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_confirmation);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        otp_one = findViewById(R.id.otp1);
        otp_two = findViewById(R.id.otp2);
        otp_three = findViewById(R.id.otp3);
        otp_four = findViewById(R.id.otp4);
        confirm=findViewById(R.id.cnfrm);
        otp_one.addTextChangedListener(this);
        otp_two.addTextChangedListener(this);
        otp_three.addTextChangedListener(this);
        otp_four.addTextChangedListener(this);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_otp_confirmation.this,khaanpin_home_page.class);
                activity_otp_confirmation.this.startActivity(intent);
                activity_otp_confirmation.this.overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
            }
        });

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 1) {
            if (otp_one.length() == 1) {
                otp_two.requestFocus();
            }

            if (otp_two.length() == 1) {
                otp_three.requestFocus();
            }
            if (otp_three.length() == 1) {
                otp_four.requestFocus();
            }
        } else if (s.length() == 0) {
            if (otp_four.length() == 0) {
                otp_three.requestFocus();
            }
            if (otp_three.length() == 0) {
                otp_two.requestFocus();
            }
            if (otp_two.length() == 0) {
                otp_one.requestFocus();
            }
        }
    }
}
