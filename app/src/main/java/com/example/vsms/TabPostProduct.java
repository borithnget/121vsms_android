package com.example.vsms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TabPostProduct extends Fragment {
    private static final String ARG_PARAM1="param1";
    private static final String ARG_PARAM2="param2";

    private String mParam1;
    private String mParam2;

    RelativeLayout relative;
    Toolbar toolbar;
    ImageView Imageview;
    TextView category,Brand,TaxType,Year,Condition,DiscoutnType,Address;
    ImageButton add;
    Button submit;
    int hint=0;

    public TabPostProduct(){}
    public static TabPostProduct newInstance(){
        TabPostProduct fragment=new TabPostProduct();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        //getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mParam1=getArguments().getString(ARG_PARAM1);
            mParam2=getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_post_product, container, false);

        relative=(RelativeLayout)view.findViewById(R.id.layout_Contact);

        BackToolbar(view);
        TextEvent(view);
        Image(view);
        ImageEvent(view);
        AddPhone(view);
        Submit(view);
        return view;
    }

    private void ImageEvent(View view) {
        LinearLayout gallery=view.findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Image click",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Submit(View view) {
        submit=(Button)view.findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Submit",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void AddPhone(View view) {
        add=(ImageButton)view.findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Add Phone ",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void BackToolbar(View view) {
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("              Post Ad");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate_before_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Clicked toolbar",Toast.LENGTH_LONG).show();
            }
        });

    }


    private void Image(View view) {
        LinearLayout gallery=view.findViewById(R.id.gallery);
        LayoutInflater inflater=LayoutInflater.from(getActivity());

        for(int i=0;i<8;i++){
            View vview=inflater.inflate(R.layout.image,gallery,false);
            ImageView imageView=vview.findViewById(R.id.image_layout);
            imageView.setImageResource(R.drawable.ic_add_box_black_24dp);
            gallery.addView(vview);

        }
    }

    private void TextEvent(View view) {
        category=(TextView)view.findViewById(R.id.etCategory);
        Brand=(TextView)view.findViewById(R.id.etBrand);
        TaxType=(TextView)view.findViewById(R.id.etTax);
        Year=(TextView)view.findViewById(R.id.etYear);
        Condition=(TextView)view.findViewById(R.id.etCondition);
        DiscoutnType=(TextView)view.findViewById(R.id.etDisType);
        Address=(TextView)view.findViewById(R.id.etAddress);


        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Choose a category",Toast.LENGTH_SHORT).show();
            }
        });

        Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Brand",Toast.LENGTH_SHORT).show();
            }
        });

        TaxType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Tax Type",Toast.LENGTH_SHORT).show();
            }
        });

        Year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Year",Toast.LENGTH_SHORT).show();
            }
        });

        Condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Condition",Toast.LENGTH_SHORT).show();
            }
        });

        DiscoutnType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Discount amount",Toast.LENGTH_SHORT).show();
            }
        });

        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Address",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
