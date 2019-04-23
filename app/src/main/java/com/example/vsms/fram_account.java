package com.example.vsms;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class fram_account extends Fragment {

    private static int RESULT_LOAD_IMAGE = 1;
    private final int requestCode1 = 2;
    private Uri Imageuri;
    ImageView imageView;
    CircleImageView circleImageView;
    ImageButton img_profile;
    Button btn_upload;
    private BottomSheetDialog bottomSheetDialog;

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fram_account,container,false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        frameLayout = (FrameLayout)view.findViewById(R.id.framlayout);

        fragment = new fram_in_post();
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framlayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0 : fragment = new fram_in_post();
                    break;
                    case 1 : fragment = new fram_notification();
                    break;
                }
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framlayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    //    final ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewPager);
    //    RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recy_in_post);


        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.edit_account_35px);
        ((AppCompatActivity)getContext()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Edit_account_setting.class);
                startActivity(intent);
            }
        });

        btn_upload = (Button)view.findViewById(R.id.btn_upload) ;
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });
        img_profile = (ImageButton)view.findViewById(R.id.btn_change_profile);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, requestCode1);
            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(getActivity(),"click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_upload:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String ShareSubject = ("Your Subject here");
                intent.putExtra(Intent.EXTRA_SUBJECT,ShareSubject);
                startActivity(Intent.createChooser(intent,"share_using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_account,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Imageuri = data.getData();
            imageView = (ImageView)getView().findViewById(R.id.image_cover) ;
            Picasso.with(getActivity()).load(Imageuri).into(imageView);
        }
        if (requestCode == requestCode1 && resultCode == RESULT_OK && null != data) {
            Imageuri = data.getData();
            circleImageView = (CircleImageView) getView().findViewById(R.id.image_profile) ;
            Picasso.with(getActivity()).load(Imageuri).into(circleImageView);
        }
        Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
    }
}
