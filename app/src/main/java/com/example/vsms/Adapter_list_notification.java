package com.example.vsms;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_list_notification extends RecyclerView.Adapter<Adapter_list_notification.ViewHolder> {
    private Class_Product_order_list[] order_lists;


//    public Adapter_list_notification(Class_Product_order_list[] order_lists){
//        this.order_lists = order_lists;
//    }

    public Adapter_list_notification(ArrayList<Class_Product_order_list> myArray) {
        this.order_lists = myArray.toArray(new Class_Product_order_list[0]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_order_list,parent,false);
        //View view = layoutInflater.inflate(R.layout.view_pending_product_post,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Class_Product_order_list order_list = order_lists[position];
        holder.image_view.setImageResource(order_lists[position].getImg_view());
        holder.brand.setText(order_lists[position].getBrand());
        holder.price.setText("Price: "+Double.toString(order_lists[position].getPrice()));
        holder.name.setText("Name: "+order_lists[position].getName());
        holder.condition.setText("Condition: "+order_lists[position].getCondition());
        holder.amt_request.setText("Amount Request: "+Double.toString(order_lists[position].getAmt_request()));

    }

    @Override
    public int getItemCount() {
        return order_lists.length;
    }

    public static  class  ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,price,condition,name,amt_request;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image_view=(ImageView)itemView.findViewById(R.id.img_view);
            this.brand=(TextView)itemView.findViewById(R.id.txtbrand);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);
            this.name = (TextView)itemView.findViewById(R.id.txtname);
            this.condition = (TextView)itemView.findViewById(R.id.txtcondition);
            this.amt_request = (TextView)itemView.findViewById(R.id.txtamount_request);

        }
    }

    public static class fram_message extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fram_message,container,false);
        }
    }
}
