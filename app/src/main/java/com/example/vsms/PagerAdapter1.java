package com.example.vsms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter1 extends FragmentPagerAdapter {
    //int mNumOfTabs;
    public PagerAdapter1(FragmentManager fm) {
        super(fm);
        //this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return Tab_Detail_Product.newInstance(1);
            default: return TabProductBalance.newInstance(2);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "Post (0)";
            default: return "Balance (7)";
        }
    }

}
