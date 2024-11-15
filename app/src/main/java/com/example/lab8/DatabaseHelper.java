package com.example.lab8;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "madlab.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "emp";

    // Column names
    private static final String COLUMN_ID = "empid";
    private static final String COLUMN_NAME = "emp_name";
    private static final String COLUMN_SALARY = "salary";
    private static final String COLUMN_JOINING_DATE = "joining_date";
    private static final String COLUMN_EDUCATION = "education";
    private static final String COLUMN_EXPERIENCE = "experience";

    // Create table SQL
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_SALARY + " INTEGER, " +
                    COLUMN_JOINING_DATE + " TEXT, " +
                    COLUMN_EDUCATION + " TEXT, " +
                    COLUMN_EXPERIENCE + " INTEGER);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(TABLE_CREATE);
            Log.d("DatabaseHelper", "Table created successfully");
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error creating table: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertEmployer(Employer employer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, employer.getEmpName());
        values.put(COLUMN_SALARY, employer.getSalary());
        values.put(COLUMN_JOINING_DATE, employer.getJoiningDate());
        values.put(COLUMN_EDUCATION, employer.getEducation());
        values.put(COLUMN_EXPERIENCE, employer.getExperience());

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            Log.e("DatabaseHelper", "Failed to insert row");
        } else {
            Log.d("DatabaseHelper", "Row inserted successfully");
        }

        db.close();
    }
}
