package com.example.corn.aninterface.databases;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class FeedReaderDbHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME= "imagetesting3.db";
    private static final int DATABASE_VERSION= 1;
    Context context;
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }
    public ArrayList<DbModelClass> getAllData(){
        try
        {
            ArrayList<DbModelClass> objDbModelClassArrayList= new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase=getWritableDatabase();
            //getReadableDatabase();
            if(objSqLiteDatabase!=null){
                //query
                Cursor objCursor = objSqLiteDatabase.rawQuery("select * from imagetesting3", null);
                if(objCursor.getCount()!=0) {
                    while(objCursor.moveToNext()){
                        //retrieving Data
                        byte[] imagesByte=  objCursor.getBlob(0);
                        Bitmap ourImage = BitmapFactory.decodeByteArray(imagesByte, 0, imagesByte.length); //error
                        objDbModelClassArrayList.add(
                                new DbModelClass(
                                        ourImage
                                )
                        );
                    }
                    return objDbModelClassArrayList;
                }else{
                    Toast.makeText(context, "No data is retrieved" ,Toast.LENGTH_SHORT).show();
                    return null;
                }
            }else{
                Toast.makeText(context, "Data is null" ,Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "getAllData" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

}