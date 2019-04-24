package com.example.vsms.Class;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vsms.R;

import java.util.ArrayList;

public class SlidingImageAdapter extends PagerAdapter {

    private ArrayList<ImageModel> imageModelArrayList;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImageAdapter(Context context,ArrayList<ImageModel> imageModelArrayList){
        this.context=context;
        this.imageModelArrayList=imageModelArrayList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }
    @Override
    public Object instantiateItem(ViewGroup viewGroup,int position){
        View view=inflater.inflate(R.layout.sliding_image_layout,viewGroup,false);
        assert view!=null;
        final ImageView imageView=(ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(imageModelArrayList.get(position).getImageDrawable());
        viewGroup.addView(view,0);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view,Object o) {
        return view.equals(o);
    }
    @Override
    public void restoreState(Parcelable state,ClassLoader loader){
    }

    @Override
    public Parcelable saveState(){
        return null;
    }
}
