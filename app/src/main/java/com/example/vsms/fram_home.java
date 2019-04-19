package com.example.vsms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class fram_home extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    int[] image_slids = {R.drawable.macbook_pro_2018,R.drawable.image_honda_dream,
                         R.drawable.image_honda_click125i_19,R.drawable.image_zoomer_x_2017};
    ViewFlipper viewFlipper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fram_home, container, false);

        Toolbar toolbar_home = (Toolbar) view.findViewById(R.id.toolbar_home);
        toolbar_home.setTitle("");
     //   getSupportActionBar().setHomeAsUpIndicator(newdrawable);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home);
        setHasOptionsMenu(true);

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar_home,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
     //   toolbar_home.setLogo(R.drawable.logo);

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//HorizontalScrollView

        Class_data_horizotal[] listdata = new Class_data_horizotal[]{
                new Class_data_horizotal(R.drawable.image_honda_dream,"Honda Dream c125",2000,1800),
                new Class_data_horizotal(R.drawable.image_honda_click125i_19,"Click 2019",1900,1660),
                new Class_data_horizotal(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,1590),
                new Class_data_horizotal(R.drawable.macbook_pro_2018,"Macbook Pro 2018",2300,1700),
                new Class_data_horizotal(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",35000,3000),
                new Class_data_horizotal(R.drawable.image_nex,"Nex 2019",1800,1000)

        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        Adapter_list_horizontal adapter = new Adapter_list_horizontal(listdata);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_horizontal);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapter);
//Vertical
        Adapter_list_horizontal adapter1=new Adapter_list_horizontal(listdata);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_vertical);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),2));
        recy_vertical.setHasFixedSize(true);
//        recy_vertical.setNestedScrollingEnabled(false);
        recy_vertical.setAdapter(adapter1);

// Slides
        viewFlipper = (ViewFlipper)view.findViewById(R.id.view_flipper);
        for(int image:image_slids){
            flipperImage(image);
        }

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_page_item,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(getContext(),"Action Search",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

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
    public void flipperImage(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);

    }
}