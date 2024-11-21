package com.example.lab9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class dbConnector extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Courses.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_COURSE = "Course";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_DURATION = "duration";
    private static final String COL_TRACKS = "tracks";
    private static final String COL_DESCRIPTION = "description";

    public dbConnector(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_COURSE + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_DURATION + " TEXT, " +
                COL_TRACKS + " TEXT, " +
                COL_DESCRIPTION + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        onCreate(db);
    }

    // Insert Data
    public boolean insertCourse(String name, String duration, String tracks, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_DURATION, duration);
        values.put(COL_TRACKS, tracks);
        values.put(COL_DESCRIPTION, description);

        long result = db.insert(TABLE_COURSE, null, values);
        return result != -1;
    }

    // Search for a course by ID
    public Course getCourseById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_COURSE + " WHERE " + COL_ID + " = ?", new String[]{String.valueOf(id)});

        if (cursor != null && cursor.moveToFirst()) {
            Course course = new Course(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            cursor.close();
            return course;
        }
        return null;
    }

    // Update a course
    public boolean updateCourse(int id, String name, String duration, String tracks, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_DURATION, duration);
        values.put(COL_TRACKS, tracks);
        values.put(COL_DESCRIPTION, description);

        int rowsAffected = db.update(TABLE_COURSE, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
        return rowsAffected > 0;
    }

    // Delete a course
    public boolean deleteCourse(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_COURSE, COL_ID + " = ?", new String[]{String.valueOf(id)});
        return rowsDeleted > 0;
    }


    // Fetch All Data
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_COURSE, null);

        if (cursor.moveToFirst()) {
            do {
                courses.add(new Course(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return courses;
    }
}