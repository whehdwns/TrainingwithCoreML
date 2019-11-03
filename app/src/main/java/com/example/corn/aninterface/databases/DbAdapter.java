package com.example.corn.aninterface.databases;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.corn.aninterface.R;

import java.util.ArrayList;
import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {
    private Context context;
    private List<DbModelClass> search;

    public DbAdapter(Context context, List<DbModelClass> search) {
        this.context = context;
        this.search = search;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imageview, parent, false);
        return new ViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder dbViewHolder, int position) {
        byte [] image = search.get(position).getOurImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        dbViewHolder.imageview.setImageBitmap(bitmap);
        //holder.setImageBitmap(search.get(position).getImage());
        // holder.imageView.setImageBitmap(convertToBitmap(search.get(position).getImage()));
        //Fixed
        ////Attempt to invoke virtual method 'void android.widget.ImageView.setImageBitmap(android.graphics.Bitmap)'
        // on a null object reference
    }

    @Override
    public int getItemCount() {
        return search.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        static ImageView imageview;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
        }
    }

}