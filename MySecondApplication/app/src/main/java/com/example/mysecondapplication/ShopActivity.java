package com.example.mysecondapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    public static int clickPowerCost = 10;
    public static int shakePowerCost = 100;
    public static int stepPowerCost = 100;

    TextView textClickPointsShop;
    TextView textClickPowerCost;
    TextView textShakePowerCost;
    TextView textStepPowerCost;
    TextView textClickPowerLvl;
    TextView textShakePowerLvl;
    TextView textStepPowerLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        textClickPointsShop=findViewById(R.id.clickPointsShop);
        textClickPowerCost = findViewById(R.id.clickPowerCost);
        textShakePowerCost = findViewById(R.id.shakePowerCost);
        textStepPowerCost = findViewById(R.id.stepPowerCost);
        textClickPowerLvl = findViewById(R.id.clickPowerLvl);
        textShakePowerLvl = findViewById(R.id.shakePowerLvl);
        textStepPowerLvl = findViewById(R.id.stepPowerLvl);
        refreshDisplay();

    }

    public void clickPowerUp(View view){
        if (MainActivity.clickPointCounter >= clickPowerCost) {
            MainActivity.clickPointCounter -= clickPowerCost;
            MainActivity.clickPower++;
            clickPowerCost = 10+MainActivity.clickPower*MainActivity.clickPower;

            refreshDisplay();
        }

    }
    public void shakePowerUp(View view) {

        if (MainActivity.clickPointCounter >= shakePowerCost) {
            MainActivity.clickPointCounter -= shakePowerCost;
            MainActivity.shakePower++;
            shakePowerCost = 100 + MainActivity.shakePower * MainActivity.shakePower;

            refreshDisplay();
        }
    }

    public void stepPowerUp(View view) {

        if (MainActivity.clickPointCounter >= stepPowerCost) {
            MainActivity.clickPointCounter -= stepPowerCost;
            MainActivity.stepPower++;
            stepPowerCost = 100+MainActivity.stepPower*MainActivity.stepPower;
        }
        refreshDisplay();
    }

    public void refreshDisplay() {
        textClickPointsShop.setText(MainActivity.clickPointCounter+"");
        textClickPowerCost.setText(clickPowerCost+"");
        textShakePowerCost.setText(shakePowerCost+"");
        textStepPowerCost.setText(stepPowerCost+"");
        textClickPowerLvl.setText(MainActivity.clickPower+"");
        textShakePowerLvl.setText(MainActivity.shakePower+"");
        textStepPowerLvl.setText(MainActivity.stepPower+"");
    }
}
