package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    public static String clickPowerString = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        TextView textview = findViewById(R.id.clickPowerDisplay);
        clickPowerString = Integer.toString(MainActivity.clickPower*10);
        textview.setText(clickPowerString);
        TextView textView = findViewById(R.id.clickPoints);
        MainActivity.clickPointString= Integer.toString(MainActivity.clickPointCounter);
        textView.setText(MainActivity.clickPointString);
    }


    public void clickPowerUp(View view){
        if (MainActivity.clickPointCounter >= (10*MainActivity.clickPower)) {
            MainActivity.clickPointCounter -=(10 * MainActivity.clickPower);
            MainActivity.clickPower++;

            TextView textview = findViewById(R.id.clickPowerDisplay);
            clickPowerString = Integer.toString(MainActivity.clickPower*10);
            textview.setText(clickPowerString);
            TextView textView = findViewById(R.id.clickPoints);
            MainActivity.clickPointString= Integer.toString(MainActivity.clickPointCounter);
            textView.setText(MainActivity.clickPointString);
        }

    }

}
