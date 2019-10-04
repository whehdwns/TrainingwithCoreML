package com.example.corn.aninterface;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.corn.aninterface.adapter.Galleryadapter;
import com.example.corn.aninterface.model.Picture;
import com.example.corn.aninterface.util.Libraries;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class loadingtraining extends AppCompatActivity {
    private RecyclerView recyclerViewGallery;
    private ArrayList<Picture> pictures;
    Galleryadapter adapter;
    private ConstraintLayout constraintLayoutSend;
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, // core pool size
            10, // max pool size
            1, TimeUnit.SECONDS, //keep alive
            new LinkedBlockingQueue<Runnable>(10), // queue
            new ThreadPoolExecutor.CallerRunsPolicy()); // handler
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long start = System.currentTimeMillis();
        setContentView(R.layout.loadingtraining);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        constraintLayoutSend = findViewById(R.id.layoutSend);
        ImageView imageViewSendDetail = findViewById(R.id.button_send);
        imageViewSendDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        pictures = new ArrayList<>();
        recyclerViewGallery = findViewById(R.id.recyclerViewGallery);
        recyclerViewGallery.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new Galleryadapter(this, pictures, new Galleryadapter.ItemListener() {
        });
        recyclerViewGallery.setAdapter(adapter);
        // handler = new Handler();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(loadingtraining.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Libraries.requestPermissionStorage(loadingtraining.this);
        } else {
            new Thread() {

                @Override
                public void run() {
                    Looper.prepare();
                    //handler.post
                    threadPoolExecutor.submit(new Runnable() {
                        //threadPoolExecutor.execute()
                        @Override
                        public void run() {
                            pictures.clear();
                            pictures.addAll(Picture.getGalleryPhotos(loadingtraining.this));
                            adapter.notifyDataSetChanged();
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
        long end = System.currentTimeMillis();
        /// Log.i("Activity", "reload time" + (end - start)/1000.0);
        System.out.println("RELOAD TIME :" + (end - start)/1000.0);
    }

    public void runTask(Runnable runnable) {
        threadPoolExecutor.execute(runnable);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}