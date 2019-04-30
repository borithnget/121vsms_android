package com.example.vsms;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    public BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
     //   getSupportFragmentManager().beginTransaction().replace(R.id.fragme_container,new fram_home()).commit();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
     //   bottomNavigationView.setSelectedItemId(Integer.parseInt(getIntent().getStringExtra("ac")));

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new fram_home();
                            break;
                        case R.id.navigation_notification:
                            selectedFragment = new fram_notification();
                            break;
                        case R.id.navigation_camera:
                            selectedFragment = new fram_camera();

                            break;
                        case R.id.navigation_chat:
                            selectedFragment = new fram_message();
                            break;
                        case R.id.navigation_account:
                            selectedFragment = new fram_account();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragme_container,selectedFragment).commit();
                    return true;
                }
            };
}
