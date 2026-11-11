package com.example.new_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    double num1 = 0;
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvResult = findViewById(R.id.tvResult);

        // All number buttons
        int[] numberIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String digit = ((Button) v).getText().toString();
                    String current = tvResult.getText().toString();

                    if (current.equals("0")) {
                        tvResult.setText(digit);          // replace the starting 0
                    } else {
                        tvResult.setText(current + digit); // add digit to the end
                    }
                }
            });
        }

        // All operator buttons
        int[] opIds = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv};

        for (int id : opIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num1 = Double.parseDouble(tvResult.getText().toString()); // save first number
                    op = ((Button) v).getText().toString();                   // save operator
                    tvResult.setText("0");                                    // ready for second number
                }
            });
        }

        // Equals button
        findViewById(R.id.btnEq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num2 = Double.parseDouble(tvResult.getText().toString());
                double result = 0;

                if (op.equals("+")) result = num1 + num2;
                else if (op.equals("-")) result = num1 - num2;
                else if (op.equals("*")) result = num1 * num2;
                else if (op.equals("/")) result = num1 / num2;

                tvResult.setText(String.valueOf(result));
            }
        });
    }
}