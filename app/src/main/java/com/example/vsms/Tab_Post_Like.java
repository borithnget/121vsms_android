package com.example.vsms;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.example.vsms.Class.ImageConverter;

import de.hdodenhof.circleimageview.CircleImageView;
import static android.app.Activity.RESULT_OK;

public class Tab_Post_Like extends Fragment {

    /*
    public static Tab_Post_Like newInStance(){
        Tab_Post_Like tab_post_like=new Tab_Post_Like();
        return tab_post_like;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    */

    ImageView profileImage,imageView;
    Button btnUpload;
    ImageButton btnChangeProfile;
    CircleImageView circleImageView;

    private static int REQUEST_LOAD_IMAGE=1;
    private final int requestCode1=2;
    private Uri imageUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_post_like, container, false);

        final ViewPager viewPager=(ViewPager) view.findViewById(R.id.pager1);
        PagerAdapter1 pagerAdapter1=new PagerAdapter1(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter1);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_account_edit_36);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.profile1);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);


        btnUpload=(Button) view.findViewById(R.id.uploadCoverButton);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,REQUEST_LOAD_IMAGE);
            }
        });

        btnChangeProfile=(ImageButton) view.findViewById(R.id.btn_change_profile);
        btnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,requestCode1);
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity().getApplicationContext(),"your icon was clicked",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), UserAccountInformation.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_delete_product,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==REQUEST_LOAD_IMAGE && resultCode==RESULT_OK && null!=data){
            imageUri=data.getData();
            imageView=(ImageView) getView().findViewById(R.id.image);
            Picasso.with(getActivity()).load(imageUri).into(imageView);
        }
        if(requestCode==requestCode1 && resultCode==RESULT_OK && null != data){
            imageUri=data.getData();
            circleImageView=(CircleImageView) getView().findViewById(R.id.image_profile);
            Picasso.with(getActivity()).load(imageUri).into(circleImageView);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                //Toast.makeText(getActivity(),"click",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(),UserAccountRegistrationActivity.class));
                break;
            case R.id.action_upload:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String ShareSubject=("Your Subject Here");
                intent.putExtra(intent.EXTRA_SUBJECT,ShareSubject);
                startActivity(Intent.createChooser(intent,"share_using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}