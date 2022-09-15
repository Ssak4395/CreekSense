package com.example.creeksense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        hideSystemBars();
        barChart = findViewById(R.id.bar_graph);
        TextView label_title = findViewById(R.id.label_title);
        Sensor s = (Sensor) getIntent().getSerializableExtra("Sensor");
        label_title.setText("Sensor " + s.getSensorTitle() + "Historical Data");
        showBarChart(s);



    }

    private void showBarChart(Sensor sensor){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for(int i = 0; i<sensor.getPhData().size(); ++i){
            BarEntry barEntry = new BarEntry(i,sensor.getPhData().get(i).floatValue());
            entries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(entries, "PH LEVELS");

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
        initBarDataSet(barDataSet);
    }

    private void initBarDataSet(BarDataSet barDataSet){
        //Changing the color of the bar
        barDataSet.setColor(Color.parseColor("#304567"));
        //Setting the size of the form in the legend
        barDataSet.setFormSize(15f);
        //showing the value of the bar, default true if not set
        barDataSet.setDrawValues(false);
        //setting the text size of the value of the bar
        barDataSet.setValueTextSize(12f);
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