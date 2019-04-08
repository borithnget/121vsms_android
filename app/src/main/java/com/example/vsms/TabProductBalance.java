package com.example.vsms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vsms.Class.BalanceListAdapter;

public class TabProductBalance extends Fragment {

    int[] images={R.drawable.image_balance1,R.drawable.image_balance1,R.drawable.image_balance1,R.drawable.image_balance1,R.drawable.image_balance1};
    String[] names={"Honda Click","Honda Click","Honda Click","Honda Click","Honda Click"};
    String[] totalNumbers={"2","2","2","2","2"};
    ListView lView;
    BalanceListAdapter lAdapter;

    public static TabProductBalance newInstance(int position){
        TabProductBalance fragment=new TabProductBalance();
        Bundle args=new Bundle();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    public TabProductBalance(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            /* mPosition = getArguments().getInt("position");*/
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_stock_balance, container, false);

        lView=(ListView) view.findViewById(R.id.list_item);
        lAdapter=new BalanceListAdapter(this.getContext(),names,totalNumbers,images);
        lView.setAdapter(lAdapter);
        lView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TabProductBalance.this.getContext(),names[position]+" has total balance "+ totalNumbers[position],Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
