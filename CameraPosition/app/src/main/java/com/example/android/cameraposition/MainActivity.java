package com.example.android.cameraposition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    boolean isMapReady;
    GoogleMap mMap;

    static final CameraPosition JAMSHEDPUR = CameraPosition.builder()
            .target(new LatLng(22.8046,86.2029))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition KOLKATA = CameraPosition.builder()
            .target(new LatLng(22.5726,88.3639))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition PATNA = CameraPosition.builder()
            .target(new LatLng(25.5941,85.1376))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kolkata = (Button) findViewById(R.id.btnKolkata);
        Button jamshedpur = (Button) findViewById(R.id.btnJamshedpur);
        Button patna = (Button) findViewById(R.id.btnPatna);

        kolkata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMapReady) {
                    flyTo(KOLKATA);
                }
            }
        });

        jamshedpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMapReady) {
                    flyTo(JAMSHEDPUR);
                }
            }
        });

        patna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMapReady) {
                    flyTo(PATNA);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target){
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 1000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        isMapReady = true;
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(JAMSHEDPUR);
    }
}
