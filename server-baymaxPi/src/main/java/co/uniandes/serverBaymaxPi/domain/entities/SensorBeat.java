package co.uniandes.serverBaymaxPi.domain.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorBeat {
    
    private final String userId;
    
    private final String doctorId;
    
    private final Date date;
    
    private final double pulse;
    
    private final double SPO2;
    
    private final double airFlow;
    
    private final double temperature;
    
    private final double electrocardiogram;
    
    private final double glucose;
    
    private final double galvanicSkinResponce;
    
    private final double bloodPressure;
    
    private final double electromyography;
    
    @JsonCreator
    public SensorBeat(@JsonProperty("userId") String userId, @JsonProperty("doctorId") String doctorId, @JsonProperty("date") Date date,
            @JsonProperty("pulse") double pulse, @JsonProperty("SPO2") double SPO2, @JsonProperty("airFlow") double airFlow, @JsonProperty("temperature") double temperature,
            @JsonProperty("electrocardiogram") double electrocardiogram, @JsonProperty("glucose") double glucose, @JsonProperty("galvanicSkinResponce") double galvanicSkinResponce, 
            @JsonProperty("bloodPressure") double bloodPressure, @JsonProperty("electromyography") double electromyography){
        
        this.userId = userId;
        this.doctorId = doctorId;
        this.date = date;
        this.pulse = pulse;
        this.SPO2 = SPO2;
        this.airFlow = airFlow;
        this.temperature = temperature;
        this.electrocardiogram = electrocardiogram;
        this.glucose = glucose;
        this.galvanicSkinResponce = galvanicSkinResponce;
        this.bloodPressure = bloodPressure; 
        this.electromyography = electromyography;
    }

    public String getUserId() {
        return userId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }

    public double getPulse() {
        return pulse;
    }

    public double getSPO2() {
        return SPO2;
    }

    public double getAirFlow() {
        return airFlow;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getElectrocardiogram() {
        return electrocardiogram;
    }

    public double getGlucose() {
        return glucose;
    }

    public double getGalvanicSkinResponce() {
        return galvanicSkinResponce;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public double getElectromyography() {
        return electromyography;
    }
}
