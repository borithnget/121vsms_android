package com.example.vsms;

import android.content.Intent;
import android.graphics.Color;
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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.vsms.Adapter_list_notification;
import com.example.vsms.Class_Product_order_list;
import com.example.vsms.R;

import java.util.ArrayList;

public class fram_notification extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Class_Product_order_list> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_notification, container, false);

        Toolbar toolbar_home = (Toolbar) view.findViewById(R.id.toolbar_home);
        toolbar_home.setTitle("Pending Product Post");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home);
        setHasOptionsMenu(true);

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar_home,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Class_Product_order_list[] order_lists = new Class_Product_order_list[]{
                new Class_Product_order_list(R.drawable.image_honda_dream,"Honda",2010,"hoka","new ",3000),
                new Class_Product_order_list(R.drawable.image_nex,"Nex 2018", 1009,"kola","Used",1000),
                new Class_Product_order_list(R.drawable.image_zoomer_x_2017,"Zoomer x",4000,"youka","old",2100),
                new Class_Product_order_list(R.drawable.image_hybrid_2017,"Hybrid 2017",34000,"Thean","oldest",2700),
                new Class_Product_order_list(R.drawable.image_nex,"Nex 3x",400,"Maki","New",100),
                new Class_Product_order_list(R.drawable.image_honda_click125i_19,"Click2018",2700,"Soka","Uesed",4100),
        };
        createItem();

        /*
        SnapRecyclerAdapter_notification adapter1 = new SnapRecyclerAdapter_notification(getContext(),items);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_notification);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),1));
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setAdapter(adapter1);

        */

        ArrayList<Class_Product_order_list> myArray = new ArrayList<Class_Product_order_list>();
        for (int i=0;i<order_lists.length;i++){
            myArray.add(order_lists[i]);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        Adapter_list_notification adapterListNotification = new Adapter_list_notification(myArray);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recyclerView);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapterListNotification);

        return view;
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

    private void createItem(){
        items = new ArrayList<>();
        items.add( new Class_Product_order_list(R.drawable.image_honda_dream,"Honda",2010,"hoka","new ",3000));
        items.add( new Class_Product_order_list(R.drawable.image_nex,"Nex 2018", 1009,"kola","Used",1000));
        items.add(new Class_Product_order_list(R.drawable.image_zoomer_x_2017,"Zoomer x",4000,"youka","old",2100));
        items.add(new Class_Product_order_list(R.drawable.image_hybrid_2017,"Hybrid 2017",34000,"Thean","oldest",2700));
        items.add( new Class_Product_order_list(R.drawable.image_nex,"Nex 3x",400,"Maki","New",100));
        items.add(new Class_Product_order_list(R.drawable.image_honda_click125i_19,"Click2018",2700,"Soka","Uesed",4100));
    }
}
