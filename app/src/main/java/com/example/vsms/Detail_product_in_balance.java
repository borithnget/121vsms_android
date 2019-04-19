package com.example.vsms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Detail_product_in_balance extends Fragment {

    ConstraintLayout grllary;
    public static Detail_product_in_balance newInstance(int position){
        Detail_product_in_balance fm = new Detail_product_in_balance();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        fm.setArguments(bundle);
        return fm;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_product_in_balance,container,false);


        return view;
    }
}
