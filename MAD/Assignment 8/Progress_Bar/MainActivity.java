package com.example.progressbardemo;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBarHorizontal, progressBarCircular;
    Button btnStart;
    TextView txtProgress;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        btnStart = findViewById(R.id.btnStart);
        txtProgress = findViewById(R.id.txtProgress);

        btnStart.setOnClickListener(view -> {

            progressBarCircular.setVisibility(View.VISIBLE);
            progress = 0;

            new Thread(() -> {
                while (progress <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progress++;

                    handler.post(() -> {
                        progressBarHorizontal.setProgress(progress);
                        txtProgress.setText("Progress: " + progress + "%");
                    });
                }

                handler.post(() -> progressBarCircular.setVisibility(View.GONE));
            }).start();
        });
    }
}