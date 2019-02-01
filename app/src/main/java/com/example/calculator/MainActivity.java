package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNumberOne;
    EditText etNumberTwo;
    TextView tvResult;
    Button btnAdd;
    Button btnMinus;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumberOne = findViewById(R.id.etNumberOne);
        etNumberTwo = findViewById(R.id.etNumberTwo);

        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = add(etNumberOne.getText().toString(), etNumberTwo.getText().toString());

                tvResult.setText("Result: " + result);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = minus(etNumberOne.getText().toString(), etNumberTwo.getText().toString());

                tvResult.setText("Result: " + result);
            }
        });


    }

    private String add(String numberOne, String numberTwo){
        if (numberOne.equals("") || numberTwo.isEmpty()){
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();

            return null;
        }

        int a = Integer.parseInt(numberOne);
        int b = Integer.parseInt(numberTwo);
        int result = a + b;

        return Integer.toString(result);
    }

    private String minus(String numberOne, String numberTwo){
        if (numberOne.equals("") || numberTwo.isEmpty()){
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();

            return null;
        }

        int a = Integer.parseInt(numberOne);
        int b = Integer.parseInt(numberTwo);
        int result = a - b;

        return Integer.toString(result);
    }
}
