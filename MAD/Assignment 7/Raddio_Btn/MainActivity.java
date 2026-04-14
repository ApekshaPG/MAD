package com.example.radiobuttondemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(getApplicationContext(),
                            "Please select an option",
                            Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = findViewById(selectedId);
                    String selectedText = radioButton.getText().toString();

                    Toast.makeText(getApplicationContext(),
                            "Selected: " + selectedText,
                            Toast.LENGTH_SHORT).show();
                }
            }

            private Context getApplicationContext() {
                return null;
            }
        });
    }
}