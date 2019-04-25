package com.example.vsms.Class;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vsms.ApprovalProductPostingDetailActivity;
import com.example.vsms.R;

public class PendingPostListAdapter extends RecyclerView.Adapter<PendingPostListAdapter.ViewHolder> {

    private ProductPostData[] listData;

    public PendingPostListAdapter(ProductPostData[] lst){
        this.listData=lst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View listItem=layoutInflater.inflate(R.layout.view_pending_product_post,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ProductPostData myData=listData[i];
        viewHolder.postTitle.setText(myData.getProductName());
        viewHolder.imageView.setImageResource(myData.getProductImage());
        viewHolder.productPrice.setText(myData.getProductPrice());
        viewHolder.condition.setText(myData.getCondition());

        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"Click Button on item:" + myData.getProductName(),Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(new Intent(v.getContext(), ApprovalProductPostingDetailActivity.class));
            }
        });

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"Click Button on item:" + myData.getProductName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView postTitle,productPrice,condition;
        public RelativeLayout relativeLayout;
        public ImageButton imageButton;

        public ViewHolder(View itemView){
            super(itemView);
            this.imageView=(ImageView) itemView.findViewById(R.id.image_product);
            this.postTitle=(TextView) itemView.findViewById(R.id.txt_post_title);
            this.productPrice=(TextView) itemView.findViewById(R.id.txt_Price);
            this.condition=(TextView) itemView.findViewById(R.id.txt_condition);
            this.imageButton=(ImageButton) itemView.findViewById(R.id.btnShowDetail);
            this.relativeLayout=(RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }

    }
}
