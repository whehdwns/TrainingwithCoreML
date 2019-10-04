package com.example.corn.aninterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class sqliteimagetraining extends AppCompatActivity {
    FeedReaderDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteimagetraining);
        db= new FeedReaderDbHelper(this);
    }

}
