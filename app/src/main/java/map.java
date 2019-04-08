import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.vsms.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;

    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng LSI=new LatLng(11.584830, 104.868699);
        map.addMarker(new MarkerOptions().position(LSI).title("LSI School"));
        map.moveCamera(CameraUpdateFactory.newLatLng(LSI));
    }
}
