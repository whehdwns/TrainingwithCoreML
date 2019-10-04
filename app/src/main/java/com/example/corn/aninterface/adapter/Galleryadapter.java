package com.example.corn.aninterface.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.corn.aninterface.R;
import com.example.corn.aninterface.model.Picture;

import java.util.List;
public class Galleryadapter extends RecyclerView.Adapter<Galleryadapter.GalleryItemViewHolder> {

    public interface ItemListener{
    }
    private ItemListener listener;

    private List<Picture> pictures;
    private Context context;

    public Galleryadapter(Context context, List<Picture> pictures, ItemListener listener) {
        this.context = context;
        this.pictures = pictures;
        this.listener=listener;
    }

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.gallery_picture, parent, false);
        return new GalleryItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemViewHolder holder, int position) {
        holder.bind(pictures.get(position), position);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }


    public class GalleryItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPictureItem;
        TextView textViewSelectCount;
        ConstraintLayout constraintLayoutItemGallery;

        public GalleryItemViewHolder(View itemView) {
            super(itemView);
            imageViewPictureItem = itemView.findViewById(R.id.imageViewPictureItem);
            textViewSelectCount = itemView.findViewById(R.id.item_gallery_select_count);
            constraintLayoutItemGallery = itemView.findViewById(R.id.gallery);
        }
        public void bind(final Picture picture, final int position) {
            RequestOptions options = new RequestOptions().skipMemoryCache(true).override(200, 200).placeholder(R.drawable.ic_launcher_background);
//                    .centerCrop()
//                    .placeholder(R.drawable.ic_camera)
//                    .error(R.drawable.ic_send)
//                    .priority(Priority.HIGH);
            Glide.with(context)
                    .load(picture.getPath())
                    .apply(options)
                    .into(imageViewPictureItem);
        }

    }

}