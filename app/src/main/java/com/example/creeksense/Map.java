package com.example.creeksense;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.creeksense.databinding.ActivityMap2Binding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Map extends FragmentActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    private ActivityMap2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMap2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hideSystemBars();
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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34.43201181012813, 150.82155408431663);
        initMarkers().stream().forEach(e-> {
              mMap.addMarker(e);
        });

        Intent i = new Intent(Map.this,SensorView.class);
        float zoomLevel = 15.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Log.d("Marker",marker.getTitle().replaceAll("\\D", ""));
                Sensor sensor = handleSensorClick(marker.getTitle().replaceAll("\\D",""));
                System.out.println("THE AIR PRESSURE IS"+ sensor.getAirPressure());
                i.putExtra("Sensor",sensor);
                startActivity(i);
                return true;
            }
        });
    }

    public LatLng[] returnLatLongs(){

        return new LatLng[]{new LatLng(-34.423745, 150.830315), new LatLng(-34.429524, 150.815325), new LatLng(-34.421591, 150.811446), new LatLng(-34.42336402208655, 150.83036223763392), new LatLng(-34.428712, 150.837278),new LatLng(-34.429941, 150.814409)};
    }

    public List<MarkerOptions> initMarkers(){
        List<MarkerOptions> listOfMarkers = new ArrayList<>();

        for(int i = 0; i<returnLatLongs().length; ++i){
             listOfMarkers.add(new MarkerOptions().position(returnLatLongs()[i]).title("Sensor" + " " + i));
        }
        return listOfMarkers;
    }


    public Sensor handleSensorClick(String sensorTitle){
        System.out.println("The sensor Title is"+ sensorTitle);
        if(sensorTitle.equals("0")){
            System.out.println("Hit sensor 0");
            Sensor sensor = new Sensor("0","Embedded Creek Sensor","AQUATIC");
            sensor.setAirPressure("14.7 PSI");
            sensor.setConductivity("200 µS/cm");
            sensor.setCreekSalinity("500mg/L");
            sensor.setDissolvedOxygenLevels("9 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("5.4 PH");
            sensor.setTurbidity("3.5 NTU");
            sensor.setWaterClarity("5.6 decimeters");
            sensor.setNitratePercentage("45% Nitrate");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);
            return sensor;
        }

        if(sensorTitle.equals("1")){
            Sensor sensor = new Sensor("1","Embedded Creek Sensor","AQUATIC");
            System.out.println("Hit sensor 1");
            sensor.setAirPressure("13.7 PSI");
            sensor.setConductivity("240 µS/cm");
            sensor.setCreekSalinity("550mg/L");
            sensor.setDissolvedOxygenLevels("7 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("4.4 PH");
            sensor.setTurbidity("6.5 NTU");
            sensor.setWaterClarity("7.6 decimeters");
            sensor.setNitratePercentage("15% Nitrate");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);
            return sensor;
        }
        if(sensorTitle.equals("2")){
            Sensor sensor = new Sensor("2","Embedded Creek Sensor","AQUATIC");
            System.out.println("Hit sensor 2");
            sensor.setAirPressure("16.7 PSI");
            sensor.setConductivity("120 µS/cm");
            sensor.setCreekSalinity("520mg/L");
            sensor.setDissolvedOxygenLevels("7 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("4.4 PH");
            sensor.setTurbidity("2.5 NTU");
            sensor.setNitratePercentage("15% Nitrate");
            sensor.setWaterClarity("6.6 decimeters");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);

            return sensor;
        }
        if(sensorTitle.equals("3")){
            Sensor sensor = new Sensor("3","Embedded Creek Sensor","AQUATIC");
            System.out.println("Hit sensor 3");
            sensor.setAirPressure("10.7 PSI");
            sensor.setConductivity("220 µS/cm");
            sensor.setCreekSalinity("530mg/L");
            sensor.setDissolvedOxygenLevels("8 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("2.4 PH");
            sensor.setTurbidity("4.5 NTU");
            sensor.setNitratePercentage("15% Nitrate");
            sensor.setWaterClarity("5.6 decimeters");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);
            return sensor;
        }
        if(sensorTitle.equals("4")){
            Sensor sensor = new Sensor("4","Embedded Creek Sensor","AQUATIC");
            System.out.println("Hit sensor 4");
            sensor.setAirPressure("16.7 PSI");
            sensor.setConductivity("100 µS/cm");
            sensor.setCreekSalinity("510mg/L");
            sensor.setDissolvedOxygenLevels("4 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("3.4 PH");
            sensor.setTurbidity("3.7 NTU");
            sensor.setNitratePercentage("45% Nitrate");
            sensor.setWaterClarity("4.6 decimeters");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);
            return sensor;
        }
        if(sensorTitle.equals("5")){
            Sensor sensor = new Sensor("5","Embedded Creek Sensor","AQUATIC");
            System.out.println("Hit sensor 5");
            sensor.setAirPressure("11.7 PSI");
            sensor.setConductivity("123 µS/cm");
            sensor.setCreekSalinity("550mg/L");
            sensor.setDissolvedOxygenLevels("7 mg O2/L ");
            sensor.setFoundHeavyMetals(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add("COPPER");
            sensor.setHeavyMetalsDetected(arrayList);
            sensor.setPhLevel("3.4 PH");
            sensor.setTurbidity("2.5 NTU");
            sensor.setWaterClarity("3.6 decimeters");
            sensor.setNitratePercentage("45% Nitrate");
            ArrayList<Double> arrayList1 = new ArrayList<>();
            arrayList1.add(2.3);
            arrayList1.add(4.56);
            arrayList1.add(5.67);
            arrayList1.add(6.76);
            arrayList1.add(3.41);
            arrayList1.add(4.21);
            sensor.setPhData(arrayList1);

            ArrayList<Double> arrayList2 = new ArrayList<>();

            arrayList2.add(130.32);
            arrayList2.add(255.32);
            arrayList2.add(542.32);
            arrayList2.add(234.32);
            arrayList2.add(345.32);

            sensor.setConductivityData(arrayList2);
            return sensor;
        }
        return null;
    }

    private void hideSystemBars() {
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        // Configure the behavior of the hidden system bars
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
    }
}