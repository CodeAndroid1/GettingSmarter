package com.gettingsmarter.gettingsmarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.*;

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
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

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

   /* public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

     public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.update) {
            Intent i = new Intent(this, UpdateActivity.class);
            startActivity(i);
        }
        else if (id == R.id.timeline) {
            Intent i = new Intent(this, TimelineActivity.class);
            startActivity(i);
        }
        else if (id == R.id.statistics) {
            Intent i = new Intent(this, StatisticsActivity.class);
            startActivity(i);
        }
        else if(id== R.id.home){
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
