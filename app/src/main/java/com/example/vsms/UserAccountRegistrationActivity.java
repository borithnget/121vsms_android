package com.example.vsms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class UserAccountRegistrationActivity extends AppCompatActivity {

    ImageButton btnFacebookLogin;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_account_registration);

        btnFacebookLogin=(ImageButton) findViewById(R.id.btnFacebookLogin);
        btnFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserAccountRegistrationActivity.this,UserAccountRegisterFacebookActivity.class);
                startActivity(i);
            }
        });

    }

}
