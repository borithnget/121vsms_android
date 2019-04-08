package com.example.vsms;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Tab_Home_Page extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    int[] images ={R.drawable.slide_1,R.drawable.slide_2,R.drawable.dream_c125,R.drawable.click};
    ViewFlipper viewFlipper;
    LinearLayout gallery,gallery1;

    private static final String ARG_PARAM1="param1";
    private static final String ARG_PARAM2="param2";
    private String mParam1;
    private String mParam2;

    public Tab_Home_Page(){

    }
    public static Tab_Home_Page newInstance(){
        Tab_Home_Page fragment=new Tab_Home_Page();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mParam1=getArguments().getString(ARG_PARAM1);
            mParam2=getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_home, container, false);

         viewFlipper = (ViewFlipper)view.findViewById(R.id.view_flipper);
         gallery = view.findViewById(R.id.gallery);
         gallery1 = view.findViewById(R.id.gallery1);

          Toolbar toolbar_home = (Toolbar) view.findViewById(R.id.toolbar_home);
          toolbar_home.setTitle("");
          ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home);
          setHasOptionsMenu(true);

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar_home, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        for(int image: images){
            flipperImage(image);
        }
        RecyclerImage();
        RecyclerImage1();
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Toast.makeText(getActivity(),"Home",Toast.LENGTH_SHORT).show();
            // Handle the camera action
        } else if (id == R.id.nav_your_post) {
            Toast.makeText(getActivity(), "Your Post", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_your_like) {
            Toast.makeText(getActivity(),"Your Like",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_loan) {
            Toast.makeText(getActivity(),"Loan",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_product_order) {
            Toast.makeText(getActivity(),"Product Oder",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home1, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:

                Toast.makeText(getActivity(),"Action Search",Toast.LENGTH_SHORT).show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void flipperImage(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);

    }

    //Deal of the Day panel
    private void RecyclerImage(){
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for(int i =0;i<10;i++){
            View view = inflater.inflate(R.layout.horizontal_image,gallery,false);
            ImageView imageView = view.findViewById(R.id.image_view);
            imageView.setImageResource(R.drawable.dream_c125);

            TextView originalPrice=view.findViewById(R.id.txtOriginalPrice);
            originalPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

            gallery.addView(view);
        }
    }
    //New Post
    private void RecyclerImage1(){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for(int i =0;i<20;i++){
            View view = inflater.inflate(R.layout.scollview_image,gallery1,false);
            ImageView imageView = view.findViewById(R.id.image_view);
            imageView.setImageResource(R.drawable.dream_c125);
            TextView txtview = (TextView)view.findViewById(R.id.textView4);
            txtview.setText("$3000");
            gallery1.addView(view);
        }
    }
}