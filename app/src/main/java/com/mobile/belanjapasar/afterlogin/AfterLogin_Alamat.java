package com.mobile.belanjapasar.afterlogin;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.activity.Register;

import java.util.ArrayList;
import java.util.List;

public class AfterLogin_Alamat extends AppCompatActivity implements OnMapReadyCallback {

    EditText ti_alamat;
    Spinner sp_kota;
    Spinner sp_provinsi;
    Button btn_ok;

    GoogleMap map;
    float a_lon = (float) -6.175566;
    float b_lat = (float) 106.827861;
    Marker customMarker;

    final Context context = this;

    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alamat_activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) context);

        ButtonListener();
        spinnerListAdapter_kota();
        spinnerListAdapter_provinsi();
    }

    /*============================================================================================*/
    public void ButtonListener()
    {
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setText("Ok");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_TanggalPengiriman.class);
                startActivity(intent);
            }
        });

    }
    /*============================================================================================*/
    public void spinnerListAdapter_kota()
    {
        sp_kota = (Spinner) findViewById(R.id.sp_kota);

        List<String> array = new ArrayList<String>();
        array.add("-- Pilih Kota --");
        array.add("Jakarta");
        array.add("Bogor");
        array.add("Tangerang");
        array.add("Bekasi");

        ArrayAdapter<String> kota = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
        kota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_kota.setAdapter(kota);

        sp_kota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sp_kota", parent.getItemAtPosition(position).toString());
                editor.commit();

                String productItemSelected = parent.getItemAtPosition(position).toString();
                if (productItemSelected.equals("-- Pilih Kota --")) {
                    //do nothing
                } else {
                    //Intent intent = new Intent(parent.getContext(), Alamat.class);
                    //startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /*============================================================================================*/
    public void spinnerListAdapter_provinsi()
    {
        sp_provinsi = (Spinner) findViewById(R.id.sp_provinsi);

        List<String> array = new ArrayList<String>();
        array.add("-- Pilih Provinsi --");
        array.add("Banten");
        array.add("DKI Jakarta");
        array.add("Jawa Barat");

        ArrayAdapter<String> provinsi = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
        provinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_provinsi.setAdapter(provinsi);

        sp_provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sp_provinsi", parent.getItemAtPosition(position).toString());
                editor.commit();

                String productItemSelected = parent.getItemAtPosition(position).toString();
                if(productItemSelected.equals("-- Pilih Provinsi --"))
                {
                    //do nothing
                }
                if(productItemSelected.equals("DKI Jakarta"))
                {
                    a_lon = (float) -6.175566;
                    b_lat = (float) 106.827861;

                    customMarker.remove();
                    MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync((OnMapReadyCallback) context);

                    Toast.makeText(getBaseContext(), "DKI Jakarta", Toast.LENGTH_SHORT).show();
                }
                if(productItemSelected.equals("Banten"))
                {
                    a_lon = (float) -6.426790;
                    b_lat = (float) 106.076376;

                    customMarker.remove();
                    MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync((OnMapReadyCallback) context);

                    Toast.makeText(getBaseContext(), "Banten", Toast.LENGTH_SHORT).show();
                }
                if(productItemSelected.equals("Jawa Barat"))
                {
                    a_lon = (float) -6.8;
                    b_lat = (float) 107.55;

                    customMarker.remove();
                    MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync((OnMapReadyCallback) context);

                    Toast.makeText(getBaseContext(), "Jawa Barat", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /*============================================================================================*/
    public void onMapReady(final GoogleMap map) {

        LatLng location = new LatLng(a_lon, b_lat);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10));

        /*----------------------------------------------------------------------------------------*/

        MarkerOptions a = new MarkerOptions()
                .title("Your Location.")
                .snippet("Anda yakin dengan lokasi ini?")
                .position(location)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                .draggable(true)
                .visible(true);

        customMarker = map.addMarker(a);

        /*----------------------------------------------------------------------------------------*/
        map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                Toast.makeText(AfterLogin_Alamat.this, "Dragging Start", Toast.LENGTH_SHORT).show();
            }
            /*--------------------------------------------------------*/
            @Override
            public void onMarkerDrag(Marker marker) {
                System.out.println("Dragging");
            }
            /*--------------------------------------------------------*/
            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng position = marker.getPosition();
                Toast.makeText(AfterLogin_Alamat.this,
                        "Lat " + position.latitude + " "
                                + "Long " + position.longitude,
                        Toast.LENGTH_SHORT).show();

            }
        });
        /*----------------------------------------------------------------------------------------*/

//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
//        new LatLng(-6.135200, 106.813301), 18));

    }

    /*============================================================================================*/

}
