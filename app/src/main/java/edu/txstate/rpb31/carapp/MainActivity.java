package edu.txstate.rpb31.carapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * My Main Class that starts with App.
 */

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from the activity_main.xml
        setContentView(R.layout.activity_main);
        // Locate the button in the activity_main.xml
        Button washButton = (Button) findViewById(R.id.btnCarWash);
        Button cabButton = (Button) findViewById(R.id.btnCabFare);


        // Capture button clicks
        cabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CabFare.class));
            }

        });
        // Capture button clicks
        washButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CarWash.class));
            }
        });




        };
    }

