package com.example.passtask4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText etName, etContact, etDob;
    Button btnUpdate, btnBack;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //init views
        etName = findViewById(R.id.et_name);
        etContact = findViewById(R.id.et_contact);
        etDob = findViewById(R.id.et_dob);
        btnUpdate = findViewById(R.id.btn_do_update);
        btnBack = findViewById(R.id.btn_back);

        dbHelper = new DBHelper(this);

        //update operation on button click
        btnUpdate.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String contact = etContact.getText().toString();
            String dob = etDob.getText().toString();
            boolean updated = dbHelper.updateuserdata(name, contact, dob);
            if (updated)
                Toast.makeText(UpdateActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(UpdateActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
        });

        //back button to return
        btnBack.setOnClickListener(v -> finish());
    }
}
