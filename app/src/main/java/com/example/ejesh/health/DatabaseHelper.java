package com.example.ejesh.health;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="User.db";
    public static final String TABLE_NAME="User_table";
    public static final String Full_Name ="FullName";
    public static final String Age ="Age";
    public static final String Gender ="Gender";
    public static final String Preferred_Day ="PreferredDay";
    public static final String Preferred_Time="PreferredTime";
    public static final String day1= "Sunday" ;
    public static final String day2= "Monday";
    public static final String day3= "Tuesday";
    public static final String day4= "Wednesday";
    public static final String day5= "Thursday";
    public static final String day6= "Friday";
    public static final String day7= "Saturday";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + "(FullName TEXT ,  Age  Integer ,Gender  TEXT , PreferredDay TEXT,  PreferredTime  TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(" DROP TABLE IF EXISTS " +TABLE_NAME);
    onCreate(db);
    }
    public boolean insertData(String name,String age) {
        SQLiteDatabase db = this.getWritableDatabase ( );
        ContentValues contentValues = new ContentValues ( );
        contentValues.put (Full_Name, name);
        contentValues.put (Age, age);
        long result = db.insert (TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
        public void insertData1(String message,String message1,String message2,String message3,String message4,String message5,String message6){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues ( );
            contentValues.put(day1,message);
            contentValues.put(day2,message1);
            contentValues.put(day3,message2);
            contentValues.put(day4,message3);
            contentValues.put(day5,message4);
            contentValues.put(day6,message5);
            contentValues.put(day7,message6);
            db.insert (TABLE_NAME,null,contentValues);


        }
    }

