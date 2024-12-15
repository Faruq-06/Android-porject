package com.example.fragmapf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity /*implements OnMapReadyCallback*/ {
//    Button next;
//    private GoogleMap map;
//    SupportMapFragment mapFragment;
    Button frag1,frag2,frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        frag1 = findViewById(R.id.frag1);
        frag2 = findViewById(R.id.frag2);
        frag3 = findViewById(R.id.frag3);
        loadfrag(new NewFragment(),0);
//        next = findViewById(R.id.show_details);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                startActivity(intent);
//            }
//        });

//        mapFragment = (SupportMapFragment)
//                getSupportFragmentManager().findFragmentById(R.id.map1);
//        mapFragment.getMapAsync(this);

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new WorkoutDetailFragment(),1);

            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new WorkoutListFragment(),1);

            }
        });
        frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new NewFragment(),1);
            }
        });
    }

//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//        map = googleMap;
//        LatLng Chittagong = new LatLng(22.3569,91.7832);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Chittagong,50));
//        MarkerOptions options = new MarkerOptions().position(Chittagong).title("Chittagong");
//        map.addMarker(options);
//
//
//    }
    public void loadfrag(Fragment fragment,int flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(flag ==0){
            fragmentTransaction.add(R.id.frame,fragment);
        }
        else{
            fragmentTransaction.replace(R.id.frame,fragment);
        }


        fragmentTransaction.commit();
    }


}