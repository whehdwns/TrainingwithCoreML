package com.example.corn.aninterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.corn.aninterface.databases.DbAdapter;
import com.example.corn.aninterface.databases.DbModelClass;
import com.example.corn.aninterface.databases.FeedReaderDbHelper;

import java.util.ArrayList;

public class sqliteimagetraining extends AppCompatActivity {
    FeedReaderDbHelper dbHelper;
    ArrayList<DbModelClass> dbarraylist;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int numcol= 3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteimagetraining);
        dbHelper=new FeedReaderDbHelper(this);
        dbarraylist=new ArrayList<>();
        recyclerView = findViewById(R.id.listview);
        try {
            dbarraylist = dbHelper.getAllData(); //error for big data
            DbAdapter objDbAdapter = new DbAdapter(dbarraylist);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new GridLayoutManager(this, numcol));
            recyclerView.setAdapter(objDbAdapter);
        }catch(Exception e){
            Toast.makeText(this, "getAllData"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
