package com.example.mysecondapplication;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.hardware.SensorManager.GRAVITY_EARTH;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static int clickPower = 1;
    public static int shakePower = 1;
    public static int clickPointCounter = 0;
    public static String clickPointString = "0";
    public static boolean accelDownwardsCheck=true;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.clickPoints);
        clickPointString= Integer.toString(clickPointCounter);
        textView.setText(clickPointString);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void sendMessage(View view) { //Pressing button
        TextView textView = findViewById(R.id.clickPoints);
        clickPointCounter+=clickPower;
        clickPointString= Integer.toString(clickPointCounter);
        textView.setText(clickPointString);
}
    public void goToShop(View view) { //Changes to Shop Activity
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }

@Override
    public void onSensorChanged(SensorEvent event) { //Checks for shaking
        if(accelDownwardsCheck) {
            if(event.values[1]-GRAVITY_EARTH<-4) {
                clickPointCounter+=shakePower;
                TextView textView = findViewById(R.id.clickPoints);
                clickPointString= Integer.toString(clickPointCounter);
                textView.setText(clickPointString);
                accelDownwardsCheck=false;
            }
        } else {
            if (event.values[1] - GRAVITY_EARTH > 4) {
                accelDownwardsCheck = true;
            }
        }
    }

@Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not in use
    }
}
