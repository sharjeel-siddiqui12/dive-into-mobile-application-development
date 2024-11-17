package com.example.mad_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "TestDatabase";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Employers";
    private static final String ID_COL = "empid";
    private static final String NAME_COL = "emp_name";
    private static final String SALARY_COL = "salary";
    private static final String JOINING_DATE_COL = "joining_date";
    private static final String EDUCATION_COL = "education";
    private static final String EXPERIENCE_COL = "experience";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " TEXT PRIMARY KEY, "
                + NAME_COL + " TEXT, "
                + SALARY_COL + " REAL, "
                + JOINING_DATE_COL + " TEXT, "
                + EDUCATION_COL + " TEXT, "
                + EXPERIENCE_COL + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addEmployer(Employer employer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_COL, employer.getEmpid());
        values.put(NAME_COL, employer.getEmp_name());
        values.put(SALARY_COL, employer.getSalary());
        values.put(JOINING_DATE_COL, employer.getJoining_date());
        values.put(EDUCATION_COL, employer.getEducation());
        values.put(EXPERIENCE_COL, employer.getExperience());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}