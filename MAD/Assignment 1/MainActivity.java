package com.example.profilepage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    Button btnLinkedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinkedIn = findViewById(R.id.btnLinkedIn);

        btnLinkedIn.setOnClickListener(v -> {
            String url = "https://www.linkedin.com/in/apeksha-gaikwad-3957692b2/";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }
}