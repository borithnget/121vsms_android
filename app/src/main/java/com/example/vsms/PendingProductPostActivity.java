package com.example.vsms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.example.vsms.Class.PendingPostListAdapter;
import com.example.vsms.Class.ProductPostData;

public class PendingProductPostActivity extends Fragment implements NavigationView.OnNavigationItemSelectedListener{
    private static final String ARG_PARAM1="param1";
    private static final String ARG_PARAM2="param2";

    private String mParam1;
    private String mParam2;
    private android.support.v7.widget.Toolbar toolbar;
    private ViewFlipper viewFlipper;

    private ProductPostData[] myListData=new ProductPostData[]{
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
            new ProductPostData("Honda Dream C125 2019",R.drawable.click,"USD 1800","New"),
    };

    public PendingProductPostActivity(){}
    public static PendingProductPostActivity newInstance(){
        PendingProductPostActivity fragment=new PendingProductPostActivity();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_pending_product_posting_list,container,false);
        viewFlipper=(ViewFlipper)view.findViewById(R.id.view_flipper);

        toolbar=view.findViewById(R.id.toolbar_home);
        toolbar.setTitle("Pending Product Posting");
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialPendingProductPost(view);

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();

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
        inflater.inflate(R.menu.home, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    private void initialPendingProductPost(View view){
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        PendingPostListAdapter adapter=new PendingPostListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }
}
