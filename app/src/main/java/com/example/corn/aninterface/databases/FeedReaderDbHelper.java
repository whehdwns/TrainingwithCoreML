package com.example.corn.aninterface.databases;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class FeedReaderDbHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME= "imagetesting3.db";
    private static final int DATABASE_VERSION= 1;
    Context context;
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }
    //get all data
    public List<DbModelClass> getsearch(){
        SQLiteDatabase db = getWritableDatabase();
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        String [] sqlSelect = {"id", "images", "date"};
        String tablename = "imagetesting3";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<DbModelClass> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                DbModelClass search = new DbModelClass();
                search.setId(cursor.getInt(cursor.getColumnIndex("id")));
                search.setOurImage(cursor.getBlob(cursor.getColumnIndex("images")));
                search.setDate(cursor.getString(cursor.getColumnIndex("date")));
                result.add(search);
            }while(cursor.moveToNext());
        }
        return result;
    }

    //function get data by date
    public List<DbModelClass> getDataBydate(String name){
        SQLiteDatabase db = getWritableDatabase();
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        String [] sqlSelect = {"id", "images", "date"};
        String tablename = "imagetesting3";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db, sqlSelect, "Date LIKE ?", new String[]{"%"+name+"%"}, null, null, null);
        List<DbModelClass> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                DbModelClass search = new DbModelClass();
                search.setId(cursor.getInt(cursor.getColumnIndex("id")));
                search.setOurImage(cursor.getBlob(cursor.getColumnIndex("images")));
                search.setDate(cursor.getString(cursor.getColumnIndex("date")));
                result.add(search);
            }while(cursor.moveToNext());
        }
        return result;
    }

}