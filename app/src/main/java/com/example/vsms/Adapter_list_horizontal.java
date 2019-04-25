package com.example.vsms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vsms.Class.Class_data_horizotal;

public class Adapter_list_horizontal extends RecyclerView.Adapter<Adapter_list_horizontal.ViewHolder> {

    private Class_data_horizotal[] listData;
    private View_buying_request[] view_buyint;

    public Adapter_list_horizontal(Class_data_horizotal[] listData){
        this.listData=listData;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listitem= layoutInflater.inflate(R.layout.image_horizontal,parent,false);
        View view_buying = layoutInflater.inflate(R.layout.activity_view_buying_request,parent,false);
        ViewHolder viewHolder = new ViewHolder(listitem);

         return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Class_data_horizotal myListData = listData[position];
        holder.image_view.setImageResource(listData[position].getImage_view());
        holder.brand.setText(listData[position].getBrand());
        holder.price.setText(Double.toString(listData[position].getPrice()));
        holder.dic.setText(Double.toString(listData[position].getDic()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click item : "+ myListData.getBrand() ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),View_buying_request.class);
                intent.putExtra("img_header",listData[position].getImage_view());
                intent.putExtra("brand",listData[position].getBrand());
                intent.putExtra("price",listData[position].getPrice());
                intent.putExtra("dic",listData[position].getDic());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public static  class  ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand;
        public TextView price;
        public TextView dic;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image_view=(ImageView)itemView.findViewById(R.id.image_view);
            this.brand=(TextView)itemView.findViewById(R.id.txtbrand);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);
            this.dic=(TextView)itemView.findViewById(R.id.txtdic);
            relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativeLayout);
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
