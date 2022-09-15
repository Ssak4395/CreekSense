package com.example.creeksense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SensorView extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {


    private LineChart mChart;
    private TextView sensorTitle;
    private TextView sensorDesc;
    private TextView sensorPH;
    private TextView sensorSalinity;
    private TextView sensorAirPressure;
    private TextView sensorTurbidity;
    private TextView sensorNitrate;
    private TextView sensorDissolvedOxygen;
    private TextView sensorWaterClarity;

    private ImageView conductGraph;
    private ImageView phGraph;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_view);

        sensorTitle = findViewById(R.id.title_tv);
        sensorDesc = findViewById(R.id.desc_tv);
        sensorPH = findViewById(R.id.ph_tv);
        sensorSalinity = findViewById(R.id.salinity_tv);
        sensorAirPressure = findViewById(R.id.air_pressure_tv);
        sensorTurbidity = findViewById(R.id.turbidity_tv);
        sensorNitrate = findViewById(R.id.nitrate_tv);
        sensorDissolvedOxygen = findViewById(R.id.o2_tv);
        sensorWaterClarity = findViewById(R.id.clarity_tv);
        phGraph = findViewById(R.id.ph_button);
        conductGraph = findViewById(R.id.conduct_button);




        Intent i = getIntent();
        Sensor sensor = (Sensor) i.getSerializableExtra("Sensor");

        String sensortit = "Sensor " + sensor.getSensorTitle();

        sensorTitle.setText(sensortit);
        sensorDesc.setText(sensor.getSensorDescription());
        sensorPH.setText(sensor.getPhLevel());
        sensorSalinity.setText(sensor.getCreekSalinity());
        sensorAirPressure.setText(sensor.getAirPressure());
        sensorTurbidity.setText(sensor.getTurbidity());
        sensorDissolvedOxygen.setText(sensor.getDissolvedOxygenLevels());
        sensorNitrate.setText(sensor.getNitratePercentage());
        sensorWaterClarity.setText(sensor.getWaterClarity());



        Intent j = new Intent(SensorView.this,Graph.class);
        phGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j.putExtra("Sensor",sensor);
                startActivity(j);
            }
        });

        conductGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j.putExtra("Sensor",sensor);
                startActivity(j);
            }
        });



        /*mChart = findViewById(R.id.lineChart);
        mChart.setOnChartGestureListener(SensorView.this);
        mChart.setOnChartValueSelectedListener(SensorView.this);
        mChart.setDragEnabled(true);


        ArrayList<Entry> entriesY = new ArrayList<>();
        entriesY.add(new Entry(0,50f));
        entriesY.add(new Entry(1,60f));
        entriesY.add(new Entry(2,70f));
        entriesY.add(new Entry(3,80f));
        entriesY.add(new Entry(4,90f));
        entriesY.add(new Entry(5,100f));



        LineDataSet set1 = new LineDataSet(entriesY,"DataY");
                set1.setFillAlpha(110);
                ArrayList<ILineDataSet> listDataset = new ArrayList<>();
                listDataset.add(set1);

                LineData data = new LineData(listDataset);
                set1.setLineWidth(3);
                set1.setColor(Color.RED);

                mChart.setData(data);*/
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}