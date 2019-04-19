package com.example.vsms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Detail_product_in_post extends Fragment {

    ConstraintLayout grllary;
    public static Detail_product_in_post newInstance(int position){
        Detail_product_in_post fm = new Detail_product_in_post();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        fm.setArguments(bundle);
        return fm;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_product_in_post,container,false);

        Class_data_in_post[] add_data = new Class_data_in_post[]{
          new Class_data_in_post(R.drawable.image_honda_click125i_19,"Click 125","2 ago","2 ago","1500"),
          new Class_data_in_post(R.drawable.image_honda_dream,"Honda","3 ago","3 ago","1900"),
          new Class_data_in_post(R.drawable.image_nex,"Nex","1 ago","1 ago","1400"),
          new Class_data_in_post(R.drawable.image_zoomer_x_2017,"Honda Zoomer X","4 ago","4 ago","2100"),
          new Class_data_in_post(R.drawable.image_hybrid_2017,"Car Hybrid","5 ago","5 ago","200450"),
          new Class_data_in_post(R.drawable.macbook_pro_2018,"Apple Macbook","3 ago","3 ago","1700"),
        };

        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        Adapter_list_post adapter=new Adapter_list_post(add_data);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_in_post);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapter);

        return view;
    }
}
