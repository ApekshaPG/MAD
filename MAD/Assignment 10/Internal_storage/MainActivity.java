package com.example.internalstoragedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave, btnRead;
    TextView textView;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        textView = findViewById(R.id.textView);

        // SAVE DATA
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // READ DATA
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fis = openFileInput(fileName);
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    fis.close();

                    String data = new String(buffer);
                    textView.setText(data);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}