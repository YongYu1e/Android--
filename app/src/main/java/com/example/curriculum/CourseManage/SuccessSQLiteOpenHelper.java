package com.example.curriculum.CourseManage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.curriculum.javabean.Success;

public class SuccessSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="Successsqlite.db";
    private static final String create_users = "create table success(successid varchar(32) primary key , successname varchar(32)," +
            "classroom varchar(32), teacher varchar(32), time varchar(32))";

    public SuccessSQLiteOpenHelper(@Nullable Context context)
    {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(create_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public long create(Success s)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("successid",s.getSuccessid());
        cv.put("successname",s.getSuccessname());
        cv.put("classroom",s.getClassroom());
        cv.put("teacher",s.getTeacher());
        cv.put("time",s.getTime());
        long suc = db.insert("success", null, cv);
        return suc;
    }

    public boolean delete(String Sid)
    {
        SQLiteDatabase db = getWritableDatabase();
        int i = db.delete("success", "successid=?",new String[]{Sid});
        if(i != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @SuppressLint("Range")
    public Success read (String Sid)
    {
        String Sna = "没有该课程数据",Cla = "没有该课程数据",Tea = "没有该课程数据",Time = "没有该课程数据";
        SQLiteDatabase db = getWritableDatabase();
        Success suc;
        Cursor success = db.query("success", null, "successid like ?", new String[]{Sid}, null, null, null);

        if(success != null)
        {
            while (success.moveToNext()) {
                Sna = success.getString(success.getColumnIndex("successname"));
                Cla = success.getString(success.getColumnIndex("classroom"));
                Tea = success.getString(success.getColumnIndex("teacher"));
                Time = success.getString(success.getColumnIndex("time"));
            }
        }

        suc = new Success(null,Sna,Cla,Tea,Time);
        return suc;
    }

    public boolean update(Success s)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("successname",s.getSuccessname());
        values.put("classroom",s.getClassroom());
        values.put("teacher",s.getTeacher());
        values.put("time",s.getTime());

        int i = db.update("success", values ,"successid=?",new String[]{s.getSuccessid()});
        if(i != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
