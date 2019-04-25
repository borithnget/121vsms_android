package com.example.vsms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fram_in_balance extends Fragment {
    private ArrayList<Item_in_balance> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fram_in_balance, container, false);

        creatItem();
        SnapRecyclerAdapter_in_balance adapter1 = new SnapRecyclerAdapter_in_balance(getContext(),items);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_in_balance);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),1));
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setAdapter(adapter1);

        return view;
    }
    private void creatItem(){
        items = new ArrayList<>();
        items.add( new Item_in_balance(R.drawable.image_honda_click125i_19,"Click 125",2));
        items.add( new Item_in_balance(R.drawable.image_honda_dream,"Honda",3));
        items.add( new Item_in_balance(R.drawable.image_nex,"Nex",1));
        items.add( new Item_in_balance(R.drawable.image_zoomer_x_2017,"Honda Zoomer X",6 ));
        items.add( new Item_in_balance(R.drawable.image_hybrid_2017,"Car Hybrid",9 ));
        items.add( new Item_in_balance(R.drawable.macbook_pro_2018,"Apple Macbook",3 ));
        items.add( new Item_in_balance(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",5));
    }
}
