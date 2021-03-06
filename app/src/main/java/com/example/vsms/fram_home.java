package com.example.vsms;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.vsms.Class.AppNavigation;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class fram_home extends Fragment {

    private SliderLayout sliderLayout;
    private DrawerLayout drawer;
    private BottomNavigationView bottomNavigationView;

    private ArrayList<Item_horizotal> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fram_home, container, false);

        View view1=inflater.inflate(R.layout.activity_main,container,false);

        bottomNavigationView=(BottomNavigationView) view1.findViewById(R.id.bottom_navigation);
        //start initial toolbar
        Toolbar toolbar_home = (Toolbar) view.findViewById(R.id.toolbar_home);
        toolbar_home.setTitle("");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home);
        setHasOptionsMenu(true);

        //start initial navigation menu
        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar_home,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        AppNavigation.setupDrawerContent(getContext(),navigationView,drawer,getActivity());

        ImageView img_motor = (ImageView)view.findViewById(R.id.image_motor);
        img_motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Sell Motorcycle",Toast.LENGTH_SHORT).show();
            }
        });
        creatItem();
        //HORIZONTAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        SnapRecyclerAdapter adapter = new SnapRecyclerAdapter(getContext(),items);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_horizontal);
        recy_horizontal.setHasFixedSize(true);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapter);
        //Vertical
        SnapRecyclerAdapter adapter1 = new SnapRecyclerAdapter(getContext(),items);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_vertical);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),2));
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setAdapter(adapter1);
        // Slides
        sliderLayout = view.findViewById(R.id.view_flipper);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(4); //set scroll delay in seconds :
        setSliderViews();

        return view;
    }
    private void creatItem(){
        items = new ArrayList<>();
        items.add( new Item_horizotal(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,1590));
        items.add( new Item_horizotal(R.drawable.image_honda_dream,"Honda Dream c125",2000,1800));
        items.add( new Item_horizotal(R.drawable.image_honda_click125i_19,"Click 2019",1900,1660));
        items.add( new Item_horizotal(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,1590));
        items.add( new Item_horizotal(R.drawable.macbook_pro_2018,"Macbook Pro 2018",2300,1700));
        items.add( new Item_horizotal(R.drawable.image_nex,"Nex 2019",1800,1000));
        items.add( new Item_horizotal(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",35000,3000));
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_page_item,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_khmer:
                Toast.makeText(getContext(),"khmer",Toast.LENGTH_SHORT).show();
                //break;
                return true;
            case R.id.action_english:
                Toast.makeText(getContext(),"english", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    /*
    implements NavigationView.OnNavigationItemSelectedListener

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.nav_profile:
                Intent intent = new Intent(getContext(),Edit_account_setting.class);
                startActivity(intent);
                break;
            case R.id.nav_your_post:
                Toast.makeText(getContext(),"Your post",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_your_like:
                Toast.makeText(getContext(),"Your Like",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_loan:
                Toast.makeText(getContext(),"Your Loan",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_product_order:
                Toast.makeText(getContext(),"Your Product Order",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_report:
                Toast.makeText(getContext(),"Report",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_language:
                Toast.makeText(getContext(),"Language",Toast.LENGTH_SHORT).show();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    */
    private void setSliderViews() {
        for (int i = 0; i < 4; i++) {
        DefaultSliderView sliderView = new DefaultSliderView(getContext());
        switch (i) {
            case 0:
                sliderView.setImageDrawable(R.drawable.image_zoomer_x_2017);
                break;
            case 1:
                sliderView.setImageDrawable(R.drawable.macbook_pro_2018);
                break;
            case 2:
                sliderView.setImageDrawable(R.drawable.image_honda_dream);
                break;
            case 3:
                sliderView.setImageDrawable(  R.drawable.image_honda_click125i_19);
                break;
        }
        sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//        sliderView.setDescription("The quick brown fox jumps over the lazy dog.\n" +
//                "Jackdaws love my big sphinx of quartz. " + (i + 1));
            final int finalI = i;

        sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(SliderView sliderView) {
                Toast.makeText(getActivity(), "This is slider " + (finalI), Toast.LENGTH_SHORT).show();
            }
        });
        //at last add this view in your layout :
        sliderLayout.addSliderView(sliderView);
     }
   }
}