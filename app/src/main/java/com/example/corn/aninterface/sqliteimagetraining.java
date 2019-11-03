package com.example.corn.aninterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.corn.aninterface.databases.DbAdapter;
import com.example.corn.aninterface.databases.DbModelClass;
import com.example.corn.aninterface.databases.FeedReaderDbHelper;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class sqliteimagetraining extends AppCompatActivity {
    FeedReaderDbHelper dbHelper;
    RecyclerView recyclerView;
    MaterialSearchBar materialSearchBar;
    DbAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int numcol= 3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteimagetraining);

        dbHelper=new FeedReaderDbHelper(this);

        recyclerView= (RecyclerView)findViewById(R.id.recycler_search);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numcol));
        recyclerView.setHasFixedSize(true);

        materialSearchBar =(MaterialSearchBar)findViewById(R.id.search_bar);
        materialSearchBar.setHint("Search: format:YYYY-MM-DD");
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
            }
            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });
        adapter = new DbAdapter(this, dbHelper.getsearch());
        recyclerView.setAdapter(adapter);
    }

    private void startSearch(String s){
        adapter = new DbAdapter(this, dbHelper.getDataBydate(s));
        recyclerView.setAdapter(adapter);
    }
}

