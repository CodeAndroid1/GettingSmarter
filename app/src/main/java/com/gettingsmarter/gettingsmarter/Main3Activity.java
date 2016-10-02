package com.gettingsmarter.gettingsmarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main3Activity extends AppCompatActivity  implements OnMapReadyCallback {
    TextView litr1;
    TextView heal1;
    TextView tech1;
    private GoogleMap mMap;
    String place;
    Double lati,longi;
    Integer litr, heal, tech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

         place = getIntent().getExtras().getString("place");
         lati = getIntent().getExtras().getDouble("latitude");
         longi = getIntent().getExtras().getDouble("longitude");

        litr = getIntent().getExtras().getInt("litr");
        heal = getIntent().getExtras().getInt("heal");
        tech = getIntent().getExtras().getInt("tech");

        litr1 = (TextView)findViewById(R.id.litr);
        heal1 = (TextView)findViewById(R.id.heal);
        tech1 = (TextView)findViewById(R.id.tech);

        litr1.setText(String.valueOf(litr));
        heal1.setText(String.valueOf(heal));
        tech1.setText(String.valueOf(tech));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(sydney).title(place));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
