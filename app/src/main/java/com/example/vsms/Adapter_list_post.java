package com.example.vsms;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter_list_post extends RecyclerView.Adapter<Adapter_list_post.ViewHolder> {

    private Item_in_post[] data_post;

    public Adapter_list_post(Item_in_post[] data_in_post){this.data_post = data_in_post;}

    @NonNull
    @Override
    public Adapter_list_post.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View listitem= layoutInflater.inflate(R.layout.detail_in_post,viewGroup,false);
        Adapter_list_post.ViewHolder viewHolder = new Adapter_list_post.ViewHolder(listitem);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter_list_post.ViewHolder holder, int i) {
        final Item_in_post mydata_post = data_post[i];
        holder.image_view.setImageResource(data_post[i].getImage_view());
        holder.brand.setText(data_post[i].getBrand());
        holder.post_on.setText(data_post[i].getPost_on());
        holder.renew_on.setText(data_post[i].getRenew_on());
        holder.price.setText(Double.toString(data_post[i].getPrice()));
        holder.btn_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Trainsfer "+mydata_post.getBrand(),Toast.LENGTH_LONG).show();
            }
        });
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Edit "+mydata_post.getBrand(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.btn_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Delect "+mydata_post.getBrand(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Menu "+mydata_post.getBrand(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_post.length;
    }
    public static  class  ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image_view;
        public TextView brand,post_on,renew_on,price;
        public Button btn_transfer,btn_edit,btn_delect,btn_menu;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image_view = (ImageView)itemView.findViewById(R.id.image_view);
            this.brand = (TextView)itemView.findViewById(R.id.txtbrand);
            this.post_on = (TextView)itemView.findViewById(R.id.txtposton);
            this.renew_on = (TextView)itemView.findViewById(R.id.txtrenew);
            this.price = (TextView)itemView.findViewById(R.id.txtprice);

            this.btn_transfer = (Button)itemView.findViewById(R.id.btn_transfer);
            this.btn_edit = (Button)itemView.findViewById(R.id.btn_edit);
            this.btn_delect = (Button)itemView.findViewById(R.id.btn_delect);
            this.btn_menu = (Button)itemView.findViewById(R.id.btn_menu);
            constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.constraintLayout);

        }
    }
}
