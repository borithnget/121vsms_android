package com.example.vsms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SnapRecyclerAdapter extends RecyclerView.Adapter<SnapRecyclerAdapter.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Item_horizotal> items;

    public SnapRecyclerAdapter(Context context, ArrayList<Item_horizotal> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.image_horizontal, parent, false);

        return new ReyclerViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, int position) {
        final Item_horizotal item = items.get(position);

        holder.image_view.setImageResource(item.getImage_view());
        holder.brand.setText(item.getBrand());
        holder.price.setText(Double.toString(item.getPrice()));
        holder.dic.setText(Double.toString(item.getDic()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click item : "+item.getBrand() ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),View_buying_request.class);
                intent.putExtra("img_header",item.getImage_view());
                intent.putExtra("brand",item.getBrand());
                intent.putExtra("price",item.getPrice());
                intent.putExtra("dic",item.getDic());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand;
        public TextView price;
        public TextView dic;
        public RelativeLayout relativeLayout;

        private ReyclerViewHolder(final View v) {
            super(v);
            this.image_view=(ImageView)itemView.findViewById(R.id.image_view);
            this.brand=(TextView)itemView.findViewById(R.id.txtbrand);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);
            this.dic=(TextView)itemView.findViewById(R.id.txtdic);
            relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativeLayout);

        }
    }
}
