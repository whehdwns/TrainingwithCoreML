package com.example.corn.aninterface;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
http://whats-online.info/science-and-tutorials/129/how-to-store-images-in-SQLite-database-in-Android-and-display-in-listview/
http://whats-online.info/science-and-tutorials/131/how-to-store-data-in-SQLite-database-in-android-example/
https://developer.android.com/training/data-storage/sqlite
http://androidminess.blogspot.com/2016/02/android-sqlite-database-simple-project.html
https://markojerkic.com/android-sqlite-cheat-sheet-without-content-provider/
http://lomza.totem-soft.com/tutorial-add-sqlcipher-to-your-android-app/
https://www.youtube.com/watch?v=6wZeSJ0U1t4
https://www.youtube.com/watch?v=lP36PcfR1j4
*/
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
