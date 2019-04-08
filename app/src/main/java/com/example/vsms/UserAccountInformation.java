package com.example.vsms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class UserAccountInformation extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_information);
        initToolBar();
    }

    public void initToolBar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
