package com.example.vsms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SnapRecyclerAdapter_in_balance extends RecyclerView.Adapter<SnapRecyclerAdapter_in_balance.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Item_in_balance> items;

    public SnapRecyclerAdapter_in_balance(Context context, ArrayList<Item_in_balance> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.detail_product_in_balance, parent, false);

        return new ReyclerViewHolder(item);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, int position) {
        final Item_in_balance item = items.get(position);

        holder.image_view.setImageResource(item.getImage_view());
        holder.brand.setText(item.getBrand());
        holder.total.setText("Total: "+item.getTotal());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,total;
        public Button btn_next;

        private ReyclerViewHolder(final View v) {
            super(v);
            this.image_view = (ImageView)itemView.findViewById(R.id.image_view);
            this.brand = (TextView)itemView.findViewById(R.id.txtbrand);
            this.total = (TextView)itemView.findViewById(R.id.txttotal);
            this.btn_next = (Button)itemView.findViewById(R.id.btn_next);

        }
    }
}
