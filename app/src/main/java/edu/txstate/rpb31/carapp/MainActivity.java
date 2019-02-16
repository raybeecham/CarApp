package edu.txstate.rpb31.carapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * My Main Class that starts with App.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button washButton = (Button) findViewById(R.id.btnCarWash);
        Button cabButton = (Button) findViewById(R.id.btnCabFare);
        Button homeButton = (Button) findViewById(R.id.btnHome);

        // Check if Cab Far button has been pressed.
        cabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CabFare.class));
            }

        });
        // Check if Car Wash button has been pressed.
        washButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CarWash.class));
            }
        });
        // Check if Home button is pressed.


    }
}
