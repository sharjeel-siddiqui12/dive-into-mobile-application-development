package com.example.mad_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CourseDB";
    private static final String TABLE_NAME = "courses";
    private static final String ID = "id";
    private static final String COURSE_NAME = "course_name";
    private static final String COURSE_CODE = "course_code";
    private static final String INSTRUCTOR = "instructor";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COURSE_NAME + " TEXT, " +
                COURSE_CODE + " TEXT, " +
                INSTRUCTOR + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCourse(String courseName, String courseCode, String instructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COURSE_NAME, courseName);
        values.put(COURSE_CODE, courseCode);
        values.put(INSTRUCTOR, instructor);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courseList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                courseList.add(new Course(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return courseList;
    }

    public boolean updateCourse(int id, String courseName, String courseCode, String instructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COURSE_NAME, courseName);
        values.put(COURSE_CODE, courseCode);
        values.put(INSTRUCTOR, instructor);

        int result = db.update(TABLE_NAME, values, ID + " = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    public boolean deleteCourse(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, ID + " = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }
}