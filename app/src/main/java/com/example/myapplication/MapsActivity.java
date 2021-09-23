package com.example.myapplication;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Location location;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double longitude = 0.0;
        double latitude = 0.0;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

        }
        else{
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if(location != null){
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }


        // Add a marker in user location
        LatLng userpos = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(userpos).title("Marker in your location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userpos));
        //Add a marker in Parque zoológico
        LatLng parqzoo = new LatLng(-23.65011685095179, -46.62034426421597);
        mMap.addMarker(new MarkerOptions().position(parqzoo).title("Marker in Parque Zoológico de São Paulo"));
        //Add a marker in Zoo Safari
        LatLng safarizoo = new LatLng(-23.65487050880165, -46.614346212365284);
        mMap.addMarker(new MarkerOptions().position(safarizoo).title("Marker in Zoo Safári"));
        //Add a marker in Foz zoo
        LatLng fozzoo = new LatLng(-23.581350958595774, -46.7054831933531);
        mMap.addMarker(new MarkerOptions().position(fozzoo).title("Marker in Zoo Foz"));
    }
}