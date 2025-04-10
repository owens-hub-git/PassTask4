package com.example.passtask4;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.passtask4.InsertActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;
            if (id == R.id.nav_insert) {
                intent = new Intent(MainActivity.this, InsertActivity.class);
            } else if (id == R.id.nav_delete) {
                intent = new Intent(MainActivity.this, DeleteActivity.class);
            } else if (id == R.id.nav_update) {
                intent = new Intent(MainActivity.this, UpdateActivity.class);
            } else if (id == R.id.nav_view) {
                intent = new Intent(MainActivity.this, ViewActivity.class);
            }

            if(intent != null) {
                startActivity(intent);
            }
            return true;
        });
    }
}
