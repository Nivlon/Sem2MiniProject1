package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int clickPower = 1;
    public static int clickPointCounter = 0;
    public static String clickPointString = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.clickPoints);
        clickPointString= Integer.toString(clickPointCounter);
        textView.setText(clickPointString);
    }

    public void sendMessage(View view) {
        TextView textView = findViewById(R.id.clickPoints);
        clickPointCounter+=clickPower;
        clickPointString= Integer.toString(clickPointCounter);
        textView.setText(clickPointString);
}
    public void goToShop(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }

    public static void refreshValues() {}
}
