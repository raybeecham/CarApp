package edu.txstate.rpb31.carapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CabFare extends MainActivity {

    double initialFee = 3.00;
    double mileageRate = 3.25;
    double numberOfMiles;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);

//       final EditText miles = (EditText) findViewById(R.id.txtNumberOfMiles);
            final Spinner spnCarType = (Spinner) findViewById(R.id.spnCarType);
            final TextView result = findViewById(R.id.txtFareResult);
            Button displayCost = (Button) findViewById(R.id.btnCalculateFare);
            final EditText txtNumberOfMiles = findViewById(R.id.txtNumberOfMiles);
            displayCost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strNumberOfMiles = txtNumberOfMiles.getText().toString();
                    int intNumberOfMiles = 0;
                    try {
                        intNumberOfMiles = Integer.parseInt(strNumberOfMiles);
                    } catch (Exception ex) {
                   result.setText("No entry detected please enter a numerical value.");
                        Toast.makeText(CabFare.this, "Please enter a number", Toast.LENGTH_LONG).show();
                        return;
                    }

               totalCost = initialFee + intNumberOfMiles * mileageRate;
               DecimalFormat currency = new DecimalFormat("$###,###.00");
               groupChoice = spnCarType.getSelectedItem().toString();

                    if (intNumberOfMiles == 0) {
                        Toast.makeText(CabFare.this, "You cannot travel 0 Miles. Please enter a valid number ", Toast.LENGTH_LONG).show();
                    } else {
                        displayResults(intNumberOfMiles, currency, result);

                    }
                }
            });
        }

    public void displayResults(int intNumberOfMiles, DecimalFormat currency, TextView result) {
        result.setText("You have requested a " + groupChoice + " to travel " +
                intNumberOfMiles +" miles,\n so the cost will be " + currency.format(totalCost));
    }
}



