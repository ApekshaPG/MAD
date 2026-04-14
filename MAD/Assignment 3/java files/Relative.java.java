package com.example.relativelayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v ->
                Toast.makeText(this,
                        "Login Button Clicked",
                        Toast.LENGTH_SHORT).show());
    }
}