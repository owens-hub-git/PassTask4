package com.example.passtask4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    EditText etName, etContact, etDob;
    Button btnInsert, btnBack;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        //initialize views from the layout
        etName = findViewById(R.id.et_name);
        etContact = findViewById(R.id.et_contact);
        etDob = findViewById(R.id.et_dob);
        btnInsert = findViewById(R.id.btn_do_insert);
        btnBack = findViewById(R.id.btn_back);

        //initialize your database helper
        dbHelper = new DBHelper(this);

        //insert button click – calls DBHelper.insertuserdata with input values
        btnInsert.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String contact = etContact.getText().toString();
            String dob = etDob.getText().toString();

            if (name.isEmpty() || contact.isEmpty() || dob.isEmpty()) {
                Toast.makeText(InsertActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = dbHelper.insertuserdata(name, contact, dob);
                if (inserted)
                    Toast.makeText(InsertActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(InsertActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        });

        //back button returns to the previous screen (MainActivity)
        btnBack.setOnClickListener(v -> finish());
    }
}
