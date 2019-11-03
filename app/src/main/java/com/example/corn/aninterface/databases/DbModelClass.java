package com.example.corn.aninterface.databases;

import android.graphics.Bitmap;

public class DbModelClass {
    public int id;
    public String date;
    byte[] ourImage;

    public DbModelClass(int id,  byte[] ourImage, String date){
        this.id = id;
        this.ourImage = ourImage;
        this.date = date;
    }
    public DbModelClass(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getOurImage() {
        return ourImage;
    }

    public void setOurImage(byte[] ourImage) {
        this.ourImage = ourImage;
    }
}