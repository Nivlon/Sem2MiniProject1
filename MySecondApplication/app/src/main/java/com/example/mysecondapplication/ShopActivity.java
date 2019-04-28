package com.example.mysecondapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    public static String clickPowerString = "0";
    public static String shakePowerString = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        TextView textview = findViewById(R.id.clickPowerCost);
        clickPowerString = Integer.toString(MainActivity.clickPower*MainActivity.clickPower);
        textview.setText(clickPowerString);
        TextView textView = findViewById(R.id.clickPoints);
        MainActivity.clickPointString= Integer.toString(MainActivity.clickPointCounter);
        textView.setText(MainActivity.clickPointString);
        TextView textview2 = findViewById(R.id.shakePowerCost);
        shakePowerString = Integer.toString(MainActivity.shakePower * MainActivity.shakePower);
        textview2.setText(shakePowerString);
    }

    public void clickPowerUp(View view){
        if (MainActivity.clickPointCounter >= (MainActivity.clickPower * MainActivity.clickPower)) {
            MainActivity.clickPointCounter -=(MainActivity.clickPower * MainActivity.clickPower);
            MainActivity.clickPower++;

            //Updates Values
            TextView textview = findViewById(R.id.clickPowerCost);
            clickPowerString = Integer.toString(MainActivity.clickPower*MainActivity.clickPower);
            textview.setText(clickPowerString);
            TextView textView = findViewById(R.id.clickPoints);
            MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
            textView.setText(MainActivity.clickPointString);


        }

    }
    public void shakePowerUp(View view) {

        if (MainActivity.clickPointCounter >= (MainActivity.shakePower * MainActivity.shakePower)) {
            MainActivity.clickPointCounter -= (MainActivity.shakePower * MainActivity.shakePower);
            MainActivity.shakePower++;

            TextView textview = findViewById(R.id.shakePowerCost);
            shakePowerString = Integer.toString(MainActivity.shakePower * MainActivity.shakePower);
            textview.setText(shakePowerString);
            TextView textView = findViewById(R.id.clickPoints);
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
        TextView textView = findViewById(R.id.clickPoints);
        MainActivity.clickPointString = Integer.toString(MainActivity.clickPointCounter);
        textView.setText(MainActivity.clickPointString);
    }
}
