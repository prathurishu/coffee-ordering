package com.example.coffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity1 = 0, quantity2 = 0, quantity3 = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void increment1(View view) {
        quantity1 += 1;
        display1(quantity1);
    }

    public void increment2(View view) {
        quantity2 += 1;
        display2(quantity2);
    }

    public void increment3(View view) {
        quantity3 += 1;
        display3(quantity3);
    }

    public void decrement1(View view) {
        if (quantity1 == 0) {
            Toast.makeText(this, "You cannot order less than 0 cups", Toast.LENGTH_LONG).show();
            return;
        }
        quantity1 -= 1;
        display1(quantity1);
    }

    public void decrement2(View view) {
        if (quantity2 == 0) {
            Toast.makeText(this, "You cannot order less than 0 cups", Toast.LENGTH_LONG).show();
            return;
        }
        quantity2 -= 1;
        display2(quantity2);
    }

    public void decrement3(View view) {
        if (quantity3 == 0) {
            Toast.makeText(this, "You cannot order less than 0 cups", Toast.LENGTH_LONG).show();
            return;
        }
        quantity3 -= 1;
        display3(quantity3);
    }

    public void display1(int number1) {
        TextView textView1 = findViewById(R.id.quantity1);
        textView1.setText("" + number1);
    }

    public void display2(int number2) {
        TextView textView2 = findViewById(R.id.quantity2);
        textView2.setText("" + number2);
    }

    public void display3(int number3) {
        TextView textView3 = findViewById(R.id.quantity3);
        textView3.setText("" + number3);
    }

    public void submitOrder(View view) {
        int coffee = quantity1 * 15 + quantity2 * 20 + quantity3 * 10;
        displayPrice(coffee);

    }

    private void displayPrice(int number) {
        TextView price = (TextView) findViewById(
                R.id.price_view);
        price.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));

    }
}