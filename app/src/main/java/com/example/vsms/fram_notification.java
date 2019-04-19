package com.example.vsms;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class fram_notification extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_notivication, container, false);

        Class_Product_order_list[] order_lists = new Class_Product_order_list[]{
                new Class_Product_order_list(R.drawable.image_honda_dream,"Honda",2010,"hoka","new ",3000),
                new Class_Product_order_list(R.drawable.image_nex,"Nex 2018", 1009,"kola","Used",1000),
                new Class_Product_order_list(R.drawable.image_zoomer_x_2017,"Zoomer x",4000,"youka","old",2100),
                new Class_Product_order_list(R.drawable.image_hybrid_2017,"Hybrid 2017",34000,"Thean","oldest",2700),
                new Class_Product_order_list(R.drawable.image_nex,"Nex 3x",400,"Maki","New",100),
                new Class_Product_order_list(R.drawable.image_honda_click125i_19,"Click2018",2700,"Soka","Uesed",4100),
        };

        ArrayList<Class_Product_order_list> myArray = new ArrayList<Class_Product_order_list>();
        for (int i=0;i<order_lists.length;i++){
            myArray.add(order_lists[i]);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        Adapter_list_notification adapterListNotification = new Adapter_list_notification(myArray);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_notification);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapterListNotification);
        return view;
    }
}
