package com.example.corn.aninterface.databases;


import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.corn.aninterface.R;

import java.util.ArrayList;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHolder> {
    ArrayList<DbModelClass> dbarraylist;

    public DbAdapter(ArrayList<DbModelClass> dbarraylist) {
        this.dbarraylist= dbarraylist;
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
        DbModelClass objDbModelClass = dbarraylist.get(position);
        ViewHolder.imageview.setImageBitmap(objDbModelClass.getOurImage());
    }

    @Override
    public int getItemCount() {
        return dbarraylist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        static ImageView imageview;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
        }
    }

}