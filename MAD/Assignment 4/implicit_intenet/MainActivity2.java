package com.example.firstproject;  // ⚠️ change to your package name

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnDial, btnAmazon, btnMaps, btnGallery, btnLinkedIn, btnYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnDial = findViewById(R.id.btnDial);
        btnAmazon = findViewById(R.id.btnAmazon);
        btnMaps = findViewById(R.id.btnMaps);
        btnGallery = findViewById(R.id.btnGallery);
        btnLinkedIn = findViewById(R.id.btnLinkedIn);
        btnYoutube = findViewById(R.id.btnYoutube);


        btnDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:97305566695"));
            startActivity(intent);
        });


        btnAmazon.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.amazon.in"));
            startActivity(intent);
        });


        btnMaps.setOnClickListener(v -> {
            Uri mapUri = Uri.parse("geo:0,0?q=Kolhapur");
            Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
            startActivity(intent);
        });


        btnGallery.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(intent);
        });


        btnLinkedIn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/feed/"));
            startActivity(intent);
        });


        btnYoutube.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com"));
            startActivity(intent);
        });
    }
}

