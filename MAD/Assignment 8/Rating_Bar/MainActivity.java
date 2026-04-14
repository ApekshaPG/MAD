package com.example.ratingbardemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnSubmit;
    TextView txtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtRating = findViewById(R.id.txtRating);

        btnSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            txtRating.setText("Rating: " + rating);
        });
    }
}