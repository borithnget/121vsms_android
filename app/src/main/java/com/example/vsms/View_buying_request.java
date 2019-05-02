package com.example.vsms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

public class View_buying_request extends AppCompatActivity {
    private static final int REQUEST_CALL= 1;
    BottomSheetDialog bottomSheetDialog;

    String[] kh_title,detail;
    TextView brand,price,dic;
    ImageView imageView;
    Button btn_order,btn_call,btn_chat,btn_loan;
    Button phone1,phone2,cancel;
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

            }
        });

        btn_loan=(Button)findViewById(R.id.btn_loan);
        btn_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new  Intent(v.getContext(),Create_Loan_request.class);
                startActivity(intent);
            }
        });

        btn_call = (Button)findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomsheet(v);  // alert bottom sheet dialog

                phone1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num = phone1.getText().toString();
                            makePhonecall(num);
                            bottomSheetDialog.dismiss();

                    }
                });
                phone2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String num = phone2.getText().toString();
                            makePhonecall(num);
                         bottomSheetDialog.dismiss();

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });


        btn_chat = (Button)findViewById(R.id.btn_chat);
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomsheet(v); // alert bottom sheet dialog

           phone1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String sms = phone1.getText().toString();
                   makeSMS(sms);
                   bottomSheetDialog.dismiss();
               }
           });

           phone2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String sms = phone2.getText().toString();
                   makeSMS(sms);
                   bottomSheetDialog.dismiss();
               }
           });

           cancel.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   bottomSheetDialog.dismiss();
               }
           });
            }
        });
    }   //   onCreate()...


    public void bottomsheet(View v){
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_call,null);
        phone1 = view.findViewById(R.id.btnPhone1);
        phone2 = view.findViewById(R.id.btnPhone2);
        cancel = view.findViewById(R.id.btnCancel);
        bottomSheetDialog = new BottomSheetDialog(v.getContext());
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottomSheetDialog.show();
    }
    public void makeSMS(String sms){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",sms,null));
        startActivity(intent);
    }

    public void makePhonecall(String num){

        if (ContextCompat.checkSelfPermission(View_buying_request.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(View_buying_request.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ num)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, @NonNull int[] grantResults ) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 &&   grantResults[0]  == PackageManager.PERMISSION_GRANTED){
              //  makePhonecall(num);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_product, menu);
        return super.onCreateOptionsMenu(menu);

    }


}
