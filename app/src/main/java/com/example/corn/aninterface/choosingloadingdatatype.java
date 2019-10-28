package com.example.corn.aninterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class choosingloadingdatatype extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosingloadingdatatype);

        findViewById(R.id.imageloaderbutton).setOnClickListener(this);
        findViewById(R.id.sqlitebutton).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageloaderbutton){
            startActivity(new Intent(choosingloadingdatatype.this, loadingtraining.class));
        }
        else if(view.getId() == R.id.sqlitebutton){
            startActivity(new Intent(choosingloadingdatatype.this,  sqliteimagetraining.class));
        }

    }
}
