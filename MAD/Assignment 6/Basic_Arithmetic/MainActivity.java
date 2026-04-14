package com.example.basicarithmeticcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.result);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSub.setOnClickListener(v -> calculate("-"));
        btnMul.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        if (num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty()) {

            result.setText("Result : Enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        double ans;

        switch (operator) {

            case "+":
                ans = n1 + n2;
                result.setText("Result : Addition = " + ans);
                break;

            case "-":
                ans = n1 - n2;
                result.setText("Result : Subtraction = " + ans);
                break;

            case "*":
                ans = n1 * n2;
                result.setText("Result : Multiplication = " + ans);
                break;

            case "/":
                if (n2 == 0) {
                    result.setText("Result : Cannot divide by zero");
                } else {
                    ans = n1 / n2;
                    result.setText("Result : Division = " + ans);
                }
                break;
        }
    }
}