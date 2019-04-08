package com.example.vsms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter2 extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter2(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return Tab_Home_Page.newInstance();
            case 1:return PendingProductPostActivity.newInstance();
            case 2:return TabPostProduct.newInstance();
            case 3:return Tab_Default.newInstance();
            default:return new Tab_Post_Like();
        }
        /*
        switch (position) {
            case 0:
                Tab_Home_Page tab1 = new Tab_Home_Page();
                return tab1;
            case 1:
                Tab_Default tab2 = new Tab_Default();
                return tab2;
            case 2:
                Tab_Default tab3 = new Tab_Default();
                return tab3;
            case 3:
                Tab_Default tab4 = new Tab_Default();
                return tab4;
            case 4:
                Tab_Post_Like tab5 = new Tab_Post_Like();
                return tab5;
            default:
                return null;
        }
        */

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
