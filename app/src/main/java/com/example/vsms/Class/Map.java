package com.example.vsms.Class;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.vsms.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_user_account_information);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng PhnomPenh = new LatLng(11.584830, 104.868699);
        map.addMarker(new MarkerOptions().position(PhnomPenh).title("Phnom Penh"));
        map.moveCamera(CameraUpdateFactory.newLatLng(PhnomPenh));
    }
}
