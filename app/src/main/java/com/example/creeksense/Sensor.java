package com.example.creeksense;

import android.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sensor implements Serializable {
    private String sensorTitle;
    private Pair<Double,Double> sensorLatLong;
    private String SensorDescription;
    private String SensorType;
    private String phLevel;
    private List<String> heavyMetalsDetected;
    private boolean foundHeavyMetals;
    private String creekSalinity;
    private String conductivity;
    private Date lastMeasuredTime;
    private int waterTemperature;
    private String airPressure;
    private String dissolvedOxygenLevels;
    private String turbidity;
    private String waterClarity;
    private String nitratePercentage;
    private List<Double> phData = new ArrayList<>();
    private List<Double> conductivityData = new ArrayList<>();

    public List<Double> getPhData() {
        return phData;
    }

    public void setPhData(List<Double> phData) {
        this.phData = phData;
    }

    public List<Double> getConductivityData() {
        return conductivityData;
    }

    public void setConductivityData(List<Double> conductivityData) {
        this.conductivityData = conductivityData;
    }

    public String getPhLevel() {
        return phLevel;
    }

    public void setPhLevel(String phLevel) {
        this.phLevel = phLevel;
    }

    public List<String> getHeavyMetalsDetected() {
        return heavyMetalsDetected;
    }

    public void setHeavyMetalsDetected(List<String> heavyMetalsDetected) {
        this.heavyMetalsDetected = heavyMetalsDetected;
    }

    public boolean isFoundHeavyMetals() {
        return foundHeavyMetals;
    }

    public void setFoundHeavyMetals(boolean foundHeavyMetals) {
        this.foundHeavyMetals = foundHeavyMetals;
    }

    public String getCreekSalinity() {
        return creekSalinity;
    }

    public void setCreekSalinity(String creekSalinity) {
        this.creekSalinity = creekSalinity;
    }

    public String getConductivity() {
        return conductivity;
    }

    public void setConductivity(String conductivity) {
        this.conductivity = conductivity;
    }

    public Date getLastMeasuredTime() {
        return lastMeasuredTime;
    }

    public void setLastMeasuredTime(Date lastMeasuredTime) {
        this.lastMeasuredTime = lastMeasuredTime;
    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public String getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }

    public String getDissolvedOxygenLevels() {
        return dissolvedOxygenLevels;
    }

    public void setDissolvedOxygenLevels(String dissolvedOxygenLevels) {
        this.dissolvedOxygenLevels = dissolvedOxygenLevels;
    }

    public String getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    public String getWaterClarity() {
        return waterClarity;
    }

    public void setWaterClarity(String waterClarity) {
        this.waterClarity = waterClarity;
    }

    public String getNitratePercentage() {
        return nitratePercentage;
    }

    public void setNitratePercentage(String nitratePercentage) {
        this.nitratePercentage = nitratePercentage;
    }

    public String getTotalDissolvedSolids() {
        return totalDissolvedSolids;
    }

    public void setTotalDissolvedSolids(String totalDissolvedSolids) {
        this.totalDissolvedSolids = totalDissolvedSolids;
    }

    private String totalDissolvedSolids;
    public String getSensorTitle() {
        return sensorTitle;
    }

    public void setSensorTitle(String sensorTitle) {
        this.sensorTitle = sensorTitle;
    }

    public Pair<Double, Double> getSensorLatLong() {
        return sensorLatLong;
    }

    public void setSensorLatLong(Pair<Double, Double> sensorLatLong) {
        this.sensorLatLong = sensorLatLong;
    }

    public String getSensorDescription() {
        return SensorDescription;
    }

    public void setSensorDescription(String sensorDescription) {
        SensorDescription = sensorDescription;
    }

    public String getSensorType() {
        return SensorType;
    }

    public void setSensorType(String sensorType) {
        SensorType = sensorType;
    }



    public Sensor(){

    }

    public Sensor(String sensorTitle, Pair<Double, Double> sensorLatLong, String sensorDescription, String sensorType) {
        this.sensorTitle = sensorTitle;
        this.sensorLatLong = sensorLatLong;
        SensorDescription = sensorDescription;
        SensorType = sensorType;
    }

    public Sensor(String sensorTitle, String sensorDescription, String sensorType) {
        this.sensorTitle = sensorTitle;
        SensorDescription = sensorDescription;
        SensorType = sensorType;
    }
}
