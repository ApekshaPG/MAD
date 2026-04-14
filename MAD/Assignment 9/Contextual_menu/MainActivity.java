package com.example.contextual_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Register context menu
        registerForContextMenu(textView);
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Option");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Handle Menu Item Click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.option1) {
            textView.setTextColor(Color.RED);
            Toast.makeText(this, "Color Changed", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.option2) {
            textView.setTextSize(30);
            Toast.makeText(this, "Size Changed", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}