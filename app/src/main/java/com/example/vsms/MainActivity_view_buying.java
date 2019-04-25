package com.example.vsms;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_view_buying extends AppCompatActivity {

    ImageButton swap;

    Button button1, button2;

    Toolbar toolbar;

    String popUpContents[];

    RecyclerView listshowrcy;

    SearchView searchView;

    SearchView shopView;

    List<Item_view_buying> productlists = new ArrayList<>();

    MainActivity_view_buying_Adapter adapter;

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Mortorbike");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.WHITE));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Item_view_buying> filtermodellist = filter(productlists, newText);
                adapter.setfilter(filtermodellist);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_shop:
                Toast.makeText(MainActivity_view_buying.this,"Action_shop",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Item_view_buying> filter(List<Item_view_buying> p1, String query) {
        query = query.toLowerCase();
        final List<Item_view_buying> filteredModeList = new ArrayList<>();
        for (Item_view_buying model : p1) {
            final String text = model.getName().toLowerCase();

            if (text.startsWith(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_buying);


        Button btnHonda = (Button)findViewById(R.id.btnHondaList);
        btnHonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_view_buying.this,"Honda Lists",Toast.LENGTH_SHORT).show();
            }
        });

        Button btnYamaha = (Button)findViewById(R.id.btnYamahaList);
        btnYamaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_view_buying.this,"Yamaha Lists",Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSuzuki = (Button)findViewById(R.id.btnSuzukiList);
        btnSuzuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_view_buying.this,"Suzuki Lists",Toast.LENGTH_SHORT).show();
            }
        });

        button1 = (Button)findViewById(R.id.btnSort);
        button2 = (Button)findViewById(R.id.btnFilter);

        listshowrcy = (RecyclerView)findViewById(R.id.listshow);
        listshowrcy.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listshowrcy.setLayoutManager(linearLayoutManager);

        ImageButton imageButton = (ImageButton) findViewById(R.id.ibtSwap);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_view_buying.this, "Swap", Toast.LENGTH_SHORT).show();
            }
        });


        initToolBar();

        productlists.add(new Item_view_buying("Honda Dream C125", R.drawable.dream_red, "Posted: 22 hrs ago", "1700$", "Color: Gold", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("SUZUKI GSX250R SPORT", R.drawable.gsx250or, "Posted: 23hrs ago", "2500$", "Color: Black", "Brand: Suzuki", "Category: Motorbike", "Year: 2018"));
        productlists.add(new Item_view_buying("PCX 2019 abs", R.drawable.pcx_2019, "Posted: 23 hrs ago", "2500$", "Color: Black", "Brand: PCX", "Category: Motorbike", "Year: 2018"));
        productlists.add(new Item_view_buying("Click 2019", R.drawable.click_2019, "Posted: 22 hrs ago", "1700$", "Color: Black", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("Fino 2019", R.drawable.fino_2019, "Posted: 23 hrs ago", "1000000$", "Color: Green", "Brand: Yamaha", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("Dream gold 2019", R.drawable.gold_dream, "Posted: 22 hrs ago", "3020$", "Color: Gold", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("MSX 2019", R.drawable.msx_2019, "Posted: 23 hrs ago", "10000$", "Color: White", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("PCX 2019", R.drawable.pcx_2019, "Posted: 22 hrs ago", "6000$", "Color: Yellow", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("Roll royce 2019", R.drawable.roll_royce_2019, "Posted: 23 hrs ago", "500$", "Color: Gray", "Brand: America", "Category: Car", "Year: 2019"));
        productlists.add(new Item_view_buying("Scoopy 2019", R.drawable.scopy_2019, "Posted: 22 hrs ago", "2000$", "Color: Blue", "Brand: Honda", "Category: Motorbike", "Year: 2019"));
        productlists.add(new Item_view_buying("Zoomer x 2019", R.drawable.zoomer_x, "Posted: 23 hrs ago", "1000$", "Color: Pink", "Brand: Honda", "Category: Motorbike", "Year: 2019"));

        adapter = new MainActivity_view_buying_Adapter(productlists, MainActivity_view_buying.this);
        listshowrcy.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu1 = new PopupMenu(MainActivity_view_buying.this,button1);
                popupMenu1.getMenuInflater().inflate(R.menu.popup_sort, popupMenu1.getMenu());

                popupMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item1) {
                        Toast.makeText(MainActivity_view_buying.this,"" + item1.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu1.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu2 = new PopupMenu(MainActivity_view_buying.this,button2);
                popupMenu2.getMenuInflater().inflate(R.menu.popup_filter, popupMenu2.getMenu());

                popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item2) {
                        Toast.makeText(MainActivity_view_buying.this,"" + item2.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu2.show();
            }
        });

    }
}