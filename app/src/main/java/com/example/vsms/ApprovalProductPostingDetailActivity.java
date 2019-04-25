package com.example.vsms;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.vsms.Class.ImageModel;
import com.example.vsms.Class.SlidingImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ApprovalProductPostingDetailActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage=0;
    private static int NUM_PAGES=0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList=new int[]{
      R.drawable.image_honda_click125i_19,
      R.drawable.image_honda_dream,
      R.drawable.image_zoomer_x_2017,
      R.drawable.image_nex
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approval_product_posting_detail_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageModelArrayList=new ArrayList<>();
        imageModelArrayList=populateList();

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_like_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private ArrayList<ImageModel> populateList(){
        ArrayList<ImageModel> list=new ArrayList<>();
        for (int i=0;i<4;i++){
            ImageModel imageModel=new ImageModel();
            imageModel.setImageDrawable(myImageList[i]);
            list.add(imageModel);
        }
        return list;
    }

    private void init(){
        mPager=(ViewPager) findViewById(R.id.viewPager);
        mPager.setAdapter(new SlidingImageAdapter(ApprovalProductPostingDetailActivity.this,imageModelArrayList));

        CirclePageIndicator indicator=(CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        final float density=getResources().getDisplayMetrics().density;
        //set circle indicator radius
        indicator.setRadius(5 * density);
        NUM_PAGES=imageModelArrayList.size();
        //Auto start of viewpager
        final Handler handler=new Handler();
        final Runnable update=new Runnable() {
            @Override
            public void run() {
                if(currentPage==NUM_PAGES){
                    currentPage=0;
                }
                mPager.setCurrentItem(currentPage++,true);
            }
        };
        Timer swipeTimer=new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },3000,3000);

        //Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage=i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
