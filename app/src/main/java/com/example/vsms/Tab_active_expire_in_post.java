package com.example.vsms;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab_active_expire_in_post extends Fragment  {

    public static Tab_active_expire_in_post newInstance(int position){
        Tab_active_expire_in_post fragment=new Tab_active_expire_in_post();
        Bundle args=new Bundle();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    public Tab_active_expire_in_post(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_active_expire_in_post, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout1);
        tabLayout.addTab(tabLayout.newTab().setText("Active ()"));
        tabLayout.addTab(tabLayout.newTab().setText("Expire Ads()"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager2);
        final PagerAdapter adapter1 = new PagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //return inflater.inflate(R.layout.tab_fragment1, container, false);
        return view;
    }

}