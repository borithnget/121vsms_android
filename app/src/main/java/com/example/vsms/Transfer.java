package com.example.vsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Transfer extends AppCompatActivity {
    Toolbar back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);

        back = (Toolbar)findViewById(R.id.tranfer_toolbar);
        back.setTitle("");
        setSupportActionBar(back);
        back.setNavigationIcon(R.drawable.back_35px);
        back.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
