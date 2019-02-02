package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class Add extends AppCompatActivity {

    private final String numberOne, numberTwo;

    Add(String numberOne, String numberTwo){
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }//constructor

    public String calculate(String numberOne, String numberTwo) {

        if (numberOne.equals("") || numberTwo.isEmpty()) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();

            return null;
        }

        int a = Integer.parseInt(numberOne);
        int b = Integer.parseInt(numberTwo);
        int result = a + b;

        return Integer.toString(result);
    }
}