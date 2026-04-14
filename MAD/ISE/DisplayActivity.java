package com.example.registrationform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvName, tvPhone;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        btnCall = findViewById(R.id.btnCall);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");

        // Use string resources with placeholders
        tvName.setText(getString(R.string.display_name, name));
        tvPhone.setText(getString(R.string.display_phone, phone));

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone));
            startActivity(intent);
        });
    }
}