package com.example.vsms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SnapRecyclerAdapter_notification extends RecyclerView.Adapter<SnapRecyclerAdapter_notification.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Class_Product_order_list> items;

    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public SnapRecyclerAdapter_notification(Context context, ArrayList<Class_Product_order_list> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    public SnapRecyclerAdapter_notification() {

    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.product_order_list, parent, false);

        return new ReyclerViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, int position) {
        final Class_Product_order_list item = items.get(position);

        holder.image_view.setImageResource(item.getImg_view());
        holder.brand.setText(item.getBrand());
        holder.price.setText("Price: "+Double.toString(item.getPrice()));
        holder.name.setText("Name: "+item.getName());
        holder.condition.setText("Condition: "+item.getCondition());
        holder.amt_request.setText("Amount Request: "+Double.toString(item.getAmt_request()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,price,condition,name,amt_request;
        public ConstraintLayout constraintLayout;

        private ReyclerViewHolder(final View v) {
            super(v);
            this.image_view=(ImageView)itemView.findViewById(R.id.img_view);
            this.brand=(TextView)itemView.findViewById(R.id.txtbrand);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);
            this.name = (TextView)itemView.findViewById(R.id.txtname);
            this.condition = (TextView)itemView.findViewById(R.id.txtcondition);
            this.amt_request = (TextView)itemView.findViewById(R.id.txtamount_request);

        }
    }
}
