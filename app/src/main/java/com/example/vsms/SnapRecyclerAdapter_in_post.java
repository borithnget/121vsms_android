package com.example.vsms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SnapRecyclerAdapter_in_post extends RecyclerView.Adapter<SnapRecyclerAdapter_in_post.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Item_in_post> items;

    public SnapRecyclerAdapter_in_post(Context context, ArrayList<Item_in_post> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.detail_in_post, parent, false);

        return new ReyclerViewHolder(item);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, final int position) {
        final Item_in_post item = items.get(position);

        holder.image_view.setImageResource(item.getImage_view());
        holder.brand.setText(item.getBrand());
        holder.post_on.setText(item.getPost_on());
        holder.renew_on.setText(item.getRenew_on());
        holder.price.setText(Double.toString(item.getPrice()));

        holder.tranfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"Transfer",Toast.LENGTH_SHORT).show();
            }

        });



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment fragment = new fram_camera();
                FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("brand",item.getBrand());
                bundle.putDouble("price",item.getPrice());
                bundle.putInt("image",item.getImage_view());
                fragment.setArguments(bundle);
                transaction.replace(R.id.fragme_container,fragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }

        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                    items.remove(position);
                                    notifyItemRemoved(position);
                                    notifyItemRangeChanged(position,items.size());
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure to delete this item?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,post_on,renew_on,price;
        public Button delete,edit,tranfer;

        private ReyclerViewHolder(final View v) {
            super(v);
            this.image_view = (ImageView)itemView.findViewById(R.id.image_view);
            this.brand = (TextView)itemView.findViewById(R.id.txtbrand);
            this.post_on = (TextView)itemView.findViewById(R.id.txtposton);
            this.renew_on = (TextView)itemView.findViewById(R.id.txtrenew);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);
            this.delete=(Button) v.findViewById(R.id.btn_delete);
            this.edit=(Button)v.findViewById(R.id.btn_edit);
            this.tranfer=(Button)v.findViewById(R.id.btn_transfer);


        }
    }
}
