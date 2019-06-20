package com.example.helloworld.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.example.helloworld.UserModel;

import java.time.Instant;

import static com.example.helloworld.UserModel.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int databaeversion=1;
    public static final String databasename="register_db";
    public DatabaseHelper(Context context){
        super(context,databasename,null,databaeversion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("drop table if exists %s", Create_Table));
        onCreate(db);
    }
    public void insertval(String usr,String pwd,String gdr,String el,String ag)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(UserModel.password,pwd);
        contentValues.put(username,usr);
        contentValues.put(age,ag);
        contentValues.put(email,el);
        contentValues.put(gender,gdr);
        db.insert(create,null,contentValues);
        db.close();


    }
    public int checkUser(String usr,String pwd){
        String[] column={id};
        SQLiteDatabase db=this.getReadableDatabase();
        String select=username+"=?"+" AND "+password+"=?";
        String[] selectionargs={usr,pwd};
        Cursor cursor = (Cursor)db.query(create, column, select, selectionargs,null,null,databasename);
        int cursorcount=cursor.getCount();
        db.close();
        if (cursorcount==0){
            return 0;
        }
else if(cursorcount>0&&cursorcount<2)
{
    return 1;
}
else
{
    return  2;
}

    }


}
