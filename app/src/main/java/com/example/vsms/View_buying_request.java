package com.example.vsms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class View_buying_request extends AppCompatActivity{

    String[] kh_title,detail;
    TextView brand,price,dic;
    ImageView imageView;
    Button btn_order;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_buying_request);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// set values
        imageView = (ImageView)findViewById(R.id.image_header);
        imageView.setImageResource(getIntent().getIntExtra("img_header",0));
        brand = (TextView)findViewById(R.id.name_product);
        brand.setText(getIntent().getStringExtra("brand"));
        price = (TextView)findViewById(R.id.name_price);
        price.setText(Double.toString(getIntent().getDoubleExtra("price",1)));
        dic = (TextView)findViewById(R.id.name_price_dic);
        dic.setText(Double.toString(getIntent().getDoubleExtra("dic",2)));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back_35px);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        kh_title = getResources().getStringArray(R.array.kh_title);
        detail = new String[]{String.valueOf(Double.toString(getIntent().getDoubleExtra("price",1))),String.valueOf(getIntent().getStringExtra("brand")),String.valueOf("2019"),String.valueOf("Good")};
        final List<HashMap<String,String>> alist = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<4;i++){
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("listview_title",kh_title[i]);
            hm.put("brand",detail[i]);
            alist.add(hm);
        }
        String[] from = {"listview_title","brand"};
        int[] to = {R.id.listview_item_title,R.id.listview_item_show};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), alist, R.layout.single_row, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

        btn_order = (Button)findViewById(R.id.btn_order);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
            //    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                intent.setAction("com.example.foo.bar.navigation_notification");
                intent.putExtra("ac","R.id.navigation_camera");
                v.getContext().startActivity(intent);


                Toast.makeText(View_buying_request.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_product, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
