package com.example.corn.aninterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.loadingtraingdata).setOnClickListener(this);
        findViewById(R.id.loadingtestingdata).setOnClickListener(this);
        findViewById(R.id.autolabeling).setOnClickListener(this);

        findViewById(R.id.modelselection).setOnClickListener(this);
        findViewById(R.id.evaluate).setOnClickListener(this);
        findViewById(R.id.keeptraininginbackground).setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.loadingtraingdata){
           //startActivity(new Intent(MainActivity.this, loadingtraining.class)); //working
            //startActivity(new Intent(MainActivity.this, sqliteimagetraining.class)); //working with small images
            Toast.makeText(this,"loading training data", Toast.LENGTH_SHORT).show();
        }else if(view.getId() == R.id.loadingtestingdata){
            Toast.makeText(this,"loading testing data", Toast.LENGTH_SHORT).show();
        }else if(view.getId() == R.id.autolabeling){
            Toast.makeText(this,"auto-labeling", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == R.id.modelselection){
            Toast.makeText(this,"model selection", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == R.id.evaluate){
            Toast.makeText(this,"evaluate", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == R.id.keeptraininginbackground){
            Toast.makeText(this,"keep training in background", Toast.LENGTH_SHORT).show();
        }
    }
}
