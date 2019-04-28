package com.example.mysecondapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    public static String clickPowerString = "0";
    public static String shakePowerString = "0";
    public static String stepPowerString = "0";
    public static int clickPowerCost = 10;
    public static int shakePowerCost = 100;
    public static int stepPowerCost = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        TextView textview0 = findViewById(R.id.clickPointsShop);
        MainActivity.clickPointString= Integer.toString(MainActivity.clickPointCounter);
        textview0.setText(MainActivity.clickPointString);

        TextView textview1 = findViewById(R.id.clickPowerCost);
        clickPowerString = Integer.toString(clickPowerCost);
        textview1.setText(clickPowerString);

        TextView textview2 = findViewById(R.id.shakePowerCost);
        shakePowerString = Integer.toString(shakePowerCost);
        textview2.setText(shakePowerString);

        TextView textview3 = findViewById(R.id.stepPowerCost);
        stepPowerString = Integer.toString(stepPowerCost);
        textview3.setText(stepPowerString);

        TextView textview4 = findViewById(R.id.clickPowerLvl);
        textview4.setText(MainActivity.clickPower+"");

        TextView textview5 = findViewById(R.id.shakePowerLvl);
        textview5.setText(MainActivity.shakePower+"");

        TextView textview6 = findViewById(R.id.stepPowerLvl);
        textview6.setText(MainActivity.stepPower+"");



    }

    public void clickPowerUp(View view){
        if (MainActivity.clickPointCounter >= clickPowerCost) {
            MainActivity.clickPointCounter -= clickPowerCost;
            MainActivity.clickPower++;
            clickPowerCost = 10+MainActivity.clickPower*MainActivity.clickPower;


            //Updates Values
            TextView textview = findViewById(R.id.clickPowerCost);
            clickPowerString = Integer.toString(clickPowerCost);
            textview.setText(clickPowerString);
            TextView textView = findViewById(R.id.clickPointsShop);
            MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
            textView.setText(MainActivity.clickPointString);

        }

    }
    public void shakePowerUp(View view) {

        if (MainActivity.clickPointCounter >= shakePowerCost) {
            MainActivity.clickPointCounter -= shakePowerCost;
            MainActivity.shakePower++;
            shakePowerCost = 100+MainActivity.shakePower^2;


            TextView textview = findViewById(R.id.shakePowerCost);
            shakePowerString = Integer.toString(shakePowerCost);
            textview.setText(shakePowerString);
            TextView textView = findViewById(R.id.clickPointsShop);
            MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
            textView.setText(MainActivity.clickPointString);
        }
    }

    public void stepPowerUp(View view) {

        if (MainActivity.clickPointCounter >= stepPowerCost) {
            MainActivity.clickPointCounter -= stepPowerCost;
            MainActivity.stepPower++;
            stepPowerCost = 100+MainActivity.stepPower^2;


            TextView textview = findViewById(R.id.stepPowerCost);
            stepPowerString = Integer.toString(stepPowerCost);
            textview.setText(stepPowerString);
            TextView textView = findViewById(R.id.clickPointsShop);
            MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
            textView.setText(MainActivity.clickPointString);
        }
    }
    public void whatPower(View view) {
        if (view.getId() == (R.id.shakePowerCost)){
            powerUp(shakePowerString, MainActivity.shakePower);
        } else if (view.getId()== (R.id.clickPowerCost)) {
            powerUp(clickPowerString, MainActivity.clickPower);
        }

    }

    public void powerUp(String pwrString, int pwrValue) {
        MainActivity.clickPointCounter -= (pwrValue * pwrValue);
        pwrValue++;

        TextView textview = findViewById(R.id.shakePowerCost);
        pwrString = Integer.toString(pwrValue * pwrValue);
        textview.setText(pwrString);
        TextView textView = findViewById(R.id.clickPointsShop);
        MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
        textView.setText(MainActivity.clickPointString);
    }
}
