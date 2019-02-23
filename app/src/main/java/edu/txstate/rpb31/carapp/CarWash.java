package edu.txstate.rpb31.carapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CarWash extends MainActivity {
    double exteriorWithPackage = 8.5;
    double exteriorNoPackage = 10.5;
    double interiorWithPackage = 12.5;
    double interiorNoPackage = 15.5;
    double totalPackage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);
        Button btnCalculatePackage = findViewById(R.id.btnCalculatePackage);
        final RadioButton exterior = (RadioButton) findViewById(R.id.radExteriorOnly);
        final RadioButton interior = (RadioButton) findViewById(R.id.radInteriorVacuum);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        final EditText txtNumberOfWashes = findViewById(R.id.txtNumberOfWashes);
        btnCalculatePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNumberOfWashes = txtNumberOfWashes.getText().toString();
                int intNumberOfWashes = 0;
                try {
                    intNumberOfWashes = Integer.parseInt(strNumberOfWashes); //int, long, float, double, boolean : primitive data type
                } catch (Exception ex) {
//                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                    displayCost(result, "No entry detected. Please try again!");
                    return;
                }

                if (intNumberOfWashes == 0) {
                    result.setText("Cannot have zero washes please\n enter a numerical amount.");
                } else {
                    result.setText("Please select a package.");
                }


                if (exterior.isChecked()) {
                    if (intNumberOfWashes >= 10) {
                        totalPackage = intNumberOfWashes * exteriorWithPackage;

                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " washes and the cost will be: ");
                    } else if (intNumberOfWashes == 0) {
                        result.setText("You must purchase at least one wash.");
                    } else if (intNumberOfWashes == 1) {
                        totalPackage = intNumberOfWashes * exteriorNoPackage;
                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " wash and the cost will be: ");

                        makeToast();
                    }
                    else {
                        totalPackage = intNumberOfWashes * exteriorNoPackage;
                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " washes and the cost will be: ");

                        makeToast();
                    }
                }

                if (interior.isChecked()) {
                    if (intNumberOfWashes >= 10) {
                        totalPackage = intNumberOfWashes * interiorWithPackage;

                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " washes and the cost will be: ");
                    } else if (intNumberOfWashes == 0) {
                        result.setText("You must purchase at least one wash.");
                    } else if (intNumberOfWashes == 1) {
                        totalPackage = intNumberOfWashes * interiorNoPackage;
                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " wash and the cost will be: ");

                        makeToast();
                    }
                    else {
                        totalPackage = intNumberOfWashes * interiorNoPackage;
                        DecimalFormat currency = makeDecimal();
                        displayCosts(intNumberOfWashes, currency, result, " washes and the cost will be: ");

                        makeToast();
                    }


                }


                }

            });
        }

    public void displayCosts(int intNumberOfWashes, DecimalFormat currency, TextView result, String s) {
        displayCost(result, "You've purchased " + intNumberOfWashes +
                s + currency.format(totalPackage));
    }


    public void displayCost(TextView result, String s) {
        result.setText(s);
    }

    public DecimalFormat makeDecimal() {
        DecimalFormat currency = new DecimalFormat("$###,###.00");
        return currency;
    }

    public void makeToast(){
        Toast.makeText(CarWash.this, "You've entered less than 10 washes. " +
                        "To be eligible for a discount please buy 10 or more washes" +
                        ".",
                + Toast.LENGTH_LONG).show();

    }


}