package com.example.popupmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(item -> {

                    int id = item.getItemId();

                    if (id == R.id.menu_settings) {
                        Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                        return true;

                    } else if (id == R.id.menu_about) {
                        Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                        return true;

                    } else if (id == R.id.menu_logout) {
                        Toast.makeText(MainActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    return false;
                });

                popupMenu.show();
            }
        });
    }
}