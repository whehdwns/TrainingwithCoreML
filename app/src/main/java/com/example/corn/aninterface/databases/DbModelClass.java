package com.example.corn.aninterface.databases;

import android.graphics.Bitmap;

public class DbModelClass {
    Bitmap ourImage;

    public DbModelClass(Bitmap ourImage){
        this.ourImage = ourImage;
    }

    public Bitmap getOurImage() {
        return ourImage;
    }

    public void setOurImage(Bitmap ourImage) {
        this.ourImage = ourImage;
    }
}