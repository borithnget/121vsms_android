package com.example.vsms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_view_buying_Adapter extends RecyclerView.Adapter<MainActivity_view_buying_Adapter.Holderview>{

    private List<Item_view_buying>productlist;
    private Context context;

    public MainActivity_view_buying_Adapter(List<Item_view_buying> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }

    @NonNull
    @Override
    public Holderview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view_buying,parent,false);
        return new Holderview(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderview holder,final int position) {
        holder.v_name.setText(productlist.get(position).getName());
        holder.v_image.setImageResource(productlist.get(position).getPhoto());
        holder.v_posted.setText(productlist.get(position).getPosted());
        holder.v_amount.setText(productlist.get(position).getAmount());
        holder.v_color.setText(productlist.get(position).getColor());
        holder.v_brand.setText(productlist.get(position).getBrand());
        holder.v_category.setText(productlist.get(position).getCategory());
        holder.v_year.setText(productlist.get(position).getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"" + productlist.get(position).getName(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public void setfilter(List<Item_view_buying>listitem){
        productlist=new ArrayList<>();
        productlist.addAll(listitem);
        notifyDataSetChanged();
    }

    class Holderview extends RecyclerView.ViewHolder{
        ImageView v_image;
        TextView v_name;
        TextView v_posted;
        TextView v_amount;
        TextView v_color;
        TextView v_brand;
        TextView v_category;
        TextView v_year;

        Holderview(View itemview){
            super(itemview);
            v_image = (ImageView) itemview.findViewById(R.id.dream);
            v_name = (TextView)itemview.findViewById(R.id.model_1);
            v_posted = (TextView)itemview.findViewById(R.id.posted_1);
            v_amount = (TextView)itemview.findViewById(R.id.amount_1);
            v_color = (TextView)itemview.findViewById(R.id.color_1);
            v_brand = (TextView)itemview.findViewById(R.id.brand_1);
            v_category = (TextView)itemview.findViewById(R.id.category_1);
            v_year = (TextView)itemview.findViewById(R.id.year_1);
        }
    }
}
