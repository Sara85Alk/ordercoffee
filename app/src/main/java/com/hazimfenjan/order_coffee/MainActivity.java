package com.hazimfenjan.order_coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quntityWhipped = 0;
    int quntityChoco = 0;

    public void increasWhipped(View view){
        quntityWhipped = quntityWhipped + 1;
        displayQuntityWhipped(quntityWhipped);
        displayTotalePrice ((quntityWhipped*5) + (quntityChoco*5) );
    }
    public void decresWhipped(View view){
        quntityWhipped = quntityWhipped - 1;
        if(quntityWhipped<0)
        {
            quntityWhipped=0;
            Toast.makeText(getApplicationContext(), "less 1 is not valid", Toast.LENGTH_SHORT).show();
            displayTotalePrice ((0) + (quntityChoco*5) );
        }
        else {
            displayQuntityWhipped(quntityWhipped);
            displayTotalePrice ((quntityWhipped*5) + (quntityChoco*5) );
        }
    }

    private void displayQuntityWhipped(int number) {
        TextView quantityTextView;
        quantityTextView = (TextView) findViewById(R.id.number_whipped);
        quantityTextView.setText("" + number);
    }

    public void increasChoc(View view){
        quntityChoco = quntityChoco + 1;
        displayQuntityChoco(quntityChoco);
        displayTotalePrice ((quntityWhipped*5) + (quntityChoco*5) );
    }
    public void decresChoc(View view){
        quntityChoco = quntityChoco - 1;
        if(quntityChoco<0)
        {
            quntityChoco=0;
            Toast.makeText(getApplicationContext(), "less 1 is not valid", Toast.LENGTH_SHORT).show();
            displayTotalePrice ((quntityWhipped*5) + 0 );
        }
        else {
            displayQuntityChoco(quntityChoco);
            displayTotalePrice ((quntityWhipped*5) + (quntityChoco*5) );
        }
    }

    private void displayQuntityChoco(int number) {
        TextView quantityTextView;
        quantityTextView = (TextView) findViewById(R.id.number_choco);
        quantityTextView.setText("" + number);
    }

    private void displayTotalePrice(int number) {
        TextView quantityTextView;
        quantityTextView = (TextView) findViewById(R.id.toltal_price);
        quantityTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
