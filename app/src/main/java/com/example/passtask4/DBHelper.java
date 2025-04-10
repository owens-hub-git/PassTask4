package com.example.passtask4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(title TEXT primary key, description TEXT, dueDate TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }


    public Boolean insertuserdata(String title, String description, String dueDate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", title);
        contentValues.put("contact", description);
        contentValues.put("dob", dueDate);

        long result = DB.insert("Userdetails", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Method to update data, copy above method and place here
    public Boolean updateuserdata(String title, String description, String dueDate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", description);
        contentValues.put("dob", dueDate);

        Cursor cursor = DB.rawQuery("Select * from Userdetails where title = ?", new String[]{title}); //3

        if (cursor.getCount() > 0) {

            long result = DB.update("Userdetails", contentValues, "title=?", new String[]{title});//2

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deletedata(String title) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails where title = ?", new String[]{title});


        if (cursor.getCount() > 0) {

            long result = DB.delete("Userdetails", "name=?", new String[]{title});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Cursor getdata() {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;


    }
}
