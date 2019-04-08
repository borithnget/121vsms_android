package com.example.vsms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Tab_Detail_Product extends Fragment {

    LinearLayout gallary1;

    public static Tab_Detail_Product newInstance(int position){
        Tab_Detail_Product fragment=new Tab_Detail_Product();
        Bundle args=new Bundle();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    public Tab_Detail_Product(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            /* mPosition = getArguments().getInt("position");*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab_post_list, container, false);
        gallary1=(LinearLayout) view.findViewById(R.id.gallery1);
        RecyclerImage1();
        return view;
    }
    private void RecyclerImage1() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for (int i = 0; i < 20; i++) {
            View view = inflater.inflate(R.layout.tab_detail_product, gallary1, false);
            gallary1.addView(view);
        }
    }
}