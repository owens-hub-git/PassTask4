package com.example.passtask4;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {
    EditText etName;
    Button btnDelete, btnBack;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


        etName = findViewById(R.id.et_name);
        btnDelete = findViewById(R.id.btn_do_delete);
        btnBack = findViewById(R.id.btn_back);


        dbHelper = new DBHelper(this);


        btnDelete.setOnClickListener(v -> {
            String name = etName.getText().toString();
            boolean deleted = dbHelper.deletedata(name);
            if (deleted)
                Toast.makeText(DeleteActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(DeleteActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
        });


        btnBack.setOnClickListener(v -> finish());
    }
}
