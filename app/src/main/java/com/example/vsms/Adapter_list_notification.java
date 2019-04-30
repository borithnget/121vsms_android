package com.example.vsms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        //View view = layoutInflater.inflate(R.layout.product_order_list,parent,false);
        View view = layoutInflater.inflate(R.layout.view_pending_product_post,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Class_Product_order_list order_list = order_lists[position];
        holder.image_view.setImageResource(order_lists[position].getImg_view());
        holder.brand.setText(order_lists[position].getBrand());
        holder.price.setText(Double.toString(order_lists[position].getPrice()));
        //holder.name.setText("Name: "+order_lists[position].getName());
        holder.condition.setText(order_lists[position].getCondition());
        holder.amt_request.setText(Double.toString(order_lists[position].getAmt_request()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                final BottomSheetDialog dialog;
                View view=LayoutInflater.from(context).inflate(R.layout.dialog_approve_reject,null);
                dialog= new BottomSheetDialog(context);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setContentView(view);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                dialog.findViewById(R.id.btnApprove).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(context).setMessage("The Product Posting has been Approve").setCancelable(false)
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                        dialog.dismiss();

                    }
                });

                dialog.findViewById(R.id.btnReject).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(context).setMessage("The Product Posting has been Reject").setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                        dialog.dismiss();
                    }
                });

                dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return order_lists.length;
    }

    public static  class  ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,price,condition,name,amt_request;
        public RelativeLayout relativeLayout;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image_view=(ImageView)itemView.findViewById(R.id.image_product);
            this.brand=(TextView)itemView.findViewById(R.id.txt_post_title);
            this.price=(TextView)itemView.findViewById(R.id.txt_Price);
            //this.name = (TextView)itemView.findViewById(R.id.txtname);
            this.condition = (TextView)itemView.findViewById(R.id.txt_condition);
            this.amt_request = (TextView)itemView.findViewById(R.id.txt_amount_request);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
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
