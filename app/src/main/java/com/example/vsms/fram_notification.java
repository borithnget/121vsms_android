package com.example.vsms;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class fram_notification extends Fragment {
    private ArrayList<Class_Product_order_list> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_notivication, container, false);

        createItem();

        SnapRecyclerAdapter_notification adapter1 = new SnapRecyclerAdapter_notification(getContext(),items);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_notification);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),1));
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setAdapter(adapter1);

        return view;
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
