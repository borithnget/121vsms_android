package com.example.vsms.Class;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vsms.R;

public class BalanceListAdapter extends BaseAdapter {
    Context context;
    private final String[] values;
    private final String[] numbers;
    private  final int[] images;

    public BalanceListAdapter(Context context, String[] values, String[] numbers, int[] images){
        //super(context, R.layout.single_list_item,);
        this.context=context;
        this.values=values;
        this.numbers=numbers;
        this.images=images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.layout_stock_balance,parent,false);
            viewHolder.txtName=(TextView) convertView.findViewById(R.id.aNameTxt);
            viewHolder.txtTotal=(TextView) convertView.findViewById(R.id.aTotal);
            viewHolder.icon=(ImageView) convertView.findViewById(R.id.appIcon);
            result=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtName.setText(values[position]);
        viewHolder.txtTotal.setText("Total :"+numbers[position]);
        viewHolder.icon.setImageResource(images[position]);
        return convertView;
    }

    private static class ViewHolder{
        TextView txtName;
        TextView txtTotal;
        ImageView icon;
    }
}
