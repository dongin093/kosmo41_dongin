package com.study.android.android_project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "lecture";

    SupportMapFragment mapFragment;
    GoogleMap map;

    MarkerOptions myLocationMarker;

    String Name;
    String Tel;
    String Lat;
    String Lon;

    Double LAT;
    Double LON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = new Intent(this.getIntent());
        Name = intent.getStringExtra("Name");
        Tel = intent.getStringExtra("Tel");
        Lat = intent.getStringExtra("Lat");
        Lon = intent.getStringExtra("Lon");
        LAT = Double.parseDouble(Lat);
        LON = Double.parseDouble(Lon);


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG,"GoogleMap is ready");

                map = googleMap;

                requestMyLocation();
            }
        });

        try {
            MapsInitializer.initialize(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void requestMyLocation() {
        LocationManager manager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            long minTime = 10000;
            float minDistance = 0;
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    }
            );

            Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation != null){
                showCurrentLocation(lastLocation);
            }

            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    minTime,
                    minDistance,
                    new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            showCurrentLocation(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    }
            );

        } catch (SecurityException e){
            e.printStackTrace();
        }
    }
    private  void showCurrentLocation(Location location){
        LatLng curPoint = new LatLng(LAT,LON);

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,15));

        showMyLocationMarker(location);
    }

    private void showMyLocationMarker(Location location) {
        if(myLocationMarker == null) {
            myLocationMarker = new MarkerOptions();
            myLocationMarker.position(new LatLng(LAT,LON));
            myLocationMarker.title(Name+"\n");
            myLocationMarker.snippet("찾아본 약국 위치");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            map.addMarker(myLocationMarker);
        }else {
            myLocationMarker.position(new LatLng(location.getLatitude(),location.getLongitude()));
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(map != null) {
            map.setMyLocationEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(map != null) {
            map.setMyLocationEnabled(true);
        }
    }
}
