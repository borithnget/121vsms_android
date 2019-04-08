package com.example.vsms;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;

public class DefaultHomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout,tabLayout_Buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_delect_product);

        inTablayotButtom();
    }
    public void inTablayotButtom(){
        tabLayout_Buttom = (TabLayout) findViewById(R.id.tab_Buttom);
        tabLayout_Buttom.addTab(tabLayout_Buttom.newTab().setIcon(R.drawable.icons8_home_40px));
        tabLayout_Buttom.addTab(tabLayout_Buttom.newTab().setIcon(R.drawable.icons8_notification_40px));
        tabLayout_Buttom.addTab(tabLayout_Buttom.newTab().setIcon(R.drawable.icons8_camera_40px));
        tabLayout_Buttom.addTab(tabLayout_Buttom.newTab().setIcon(R.drawable.icons8_chat_40px));
        tabLayout_Buttom.addTab(tabLayout_Buttom.newTab().setIcon(R.drawable.icons8_account_40px));

        tabLayout_Buttom.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter2 adapter2 = new PagerAdapter2(getSupportFragmentManager(), tabLayout_Buttom.getTabCount());
        viewPager.setAdapter(adapter2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_Buttom));
        tabLayout_Buttom.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(Color.parseColor("#FF386AC7"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#FF696969"), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_product,menu);
        return true;
    }
}