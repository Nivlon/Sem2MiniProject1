package com.example.mysecondapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.hardware.SensorManager.GRAVITY_EARTH;
import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static int clickPower = 1;
    public static int shakePower = 0;
    public static int stepPower = 0;
    public static int clickPointCounter = 0;
    public static boolean accelDownwardsCheck=true;
    public static boolean isCatWoke=true;

    TextView textClickPoints;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Text Update
        textClickPoints = findViewById(R.id.clickPoints);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR), SensorManager.SENSOR_DELAY_UI);
        refreshDisplay();
    }

    public void sendMessage(View view) { //Pressing button
        clickPointCounter+=clickPower;
        isCatWoke=!isCatWoke;
        refreshDisplay();
    }

    public void goToShop(View view) { //Changes to Shop Activity
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
        refreshDisplay();
    }

    @Override
    public void onSensorChanged(SensorEvent event) { //Checks for shaking
        Button catbutton=findViewById(R.id.catbutton);
        if(isCatWoke){
            catbutton.setBackgroundResource(R.drawable.catwake);
        } else {
            catbutton.setBackgroundResource(R.drawable.cat);
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if(accelDownwardsCheck) {
                if(event.values[1]-GRAVITY_EARTH<-5) {
                    clickPointCounter += shakePower;
                    accelDownwardsCheck = false;
                }
            } else {
                if (event.values[1] - GRAVITY_EARTH > 5) {
                    accelDownwardsCheck = true;
                }
            }
        }else if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            clickPointCounter+=stepPower;
        }
        refreshDisplay();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not in use
    }

    public void refreshDisplay() {
        textClickPoints.setText(clickPointCounter+"");
    }

}
