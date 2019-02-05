package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNumberOne;
    EditText etNumberTwo;
    TextView tvResult;
    Button btnAdd;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;

    Button btnLog;

    String result;

    private List<String> log = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumberOne = findViewById(R.id.etNumberOne);
        etNumberTwo = findViewById(R.id.etNumberTwo);

        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnLog = findViewById(R.id.btnLog);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() { //set value that user entered into variable
            @Override
            public void onClick(View v) {
                Add add = new Add(etNumberOne.getText().toString(), etNumberTwo.getText().toString());
                result = add.calculate(etNumberOne.getText().toString(), etNumberTwo.getText().toString());                tvResult.setText("Result: " + result);

                log.add("Result of Addition: " + result);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Minus minus = new Minus(etNumberOne.getText().toString(), etNumberTwo.getText().toString());
                result = minus.calculate(etNumberOne.getText().toString(), etNumberTwo.getText().toString());

                tvResult.setText("Result: " + result);

                log.add("Result of Minus: " + result);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Multiply multiply = new Multiply(etNumberOne.getText().toString(), etNumberTwo.getText().toString());
                result = multiply.calculate(etNumberOne.getText().toString(), etNumberTwo.getText().toString());

                tvResult.setText("Result: "+ result);

                log.add("Result of Multiple: " + result);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Divide divide = new Divide(etNumberOne.getText().toString(), etNumberTwo.getText().toString());
                result = divide.calculate(etNumberOne.getText().toString(), etNumberTwo.getText().toString());

                tvResult.setText("Result: " + result);

                log.add("Result of Divide: " + result);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogsActivity.class);
                intent.putStringArrayListExtra("LogsResult", (ArrayList<String>)log);
                Bus bus = new Bus("Grey", "Black");
                intent.putExtra("Bus", bus);

                Room room = new Room("Training Room", 4);
                intent.putExtra("Room", room);
                startActivity(intent);
            }
        });

    }
}// end of MainActivity Class
