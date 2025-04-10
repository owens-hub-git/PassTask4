package com.example.passtask4;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    Button btnView, btnBack;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        btnView = findViewById(R.id.btn_do_view);
        btnBack = findViewById(R.id.btn_back);
        dbHelper = new DBHelper(this);

        btnView.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getdata();
            if (cursor.getCount() == 0) {
                Toast.makeText(ViewActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("Title: " + cursor.getString(0) + "\n");
                buffer.append("Description: " + cursor.getString(1) + "\n");
                buffer.append("Due Date: " + cursor.getString(2) + "\n");
                buffer.append("\n");
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
            builder.setCancelable(true);
            builder.setTitle("User Entries");
            builder.setMessage(buffer.toString());
            builder.show();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
