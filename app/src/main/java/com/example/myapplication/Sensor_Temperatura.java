package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Sensor_Temperatura extends AppCompatActivity implements SensorEventListener {
    private TextView texttemp;
    private SensorManager sensorManager;
    private Sensor tempsensor;
    private Boolean tempeavalible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texttemp = findViewById(R.id.txtemp);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
            tempsensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        }
        else{
            texttemp.setText("Sensor de Temperatura não está disponivel");
            tempeavalible = false;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.values[0] >= 20){
            texttemp.setText(sensorEvent.values[0]+" °C" + " Hoje está um dia bom para ir ao parque");

        }else{
            texttemp.setText(sensorEvent.values[0]+" °C" + " Hoje está frio o animais estaram dormindo");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tempeavalible){
            sensorManager.registerListener( this, tempsensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (tempeavalible){
            sensorManager.unregisterListener(this);
        }
    }
}