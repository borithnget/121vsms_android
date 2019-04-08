package com.example.vsms;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mtoolbar = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mtoolbar.setOnNavigationItemSelectedListener(navListener);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragme_container,new fram_home()).commit();

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
