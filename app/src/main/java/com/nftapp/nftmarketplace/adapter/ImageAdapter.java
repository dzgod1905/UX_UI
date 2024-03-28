package com.nftapp.nftmarketplace.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nftapp.nftmarketplace.Intreface.ImageOnClick;
import com.nftapp.nftmarketplace.MainActivity;
import com.nftapp.nftmarketplace.PaintActivity;
import com.nftapp.nftmarketplace.ViewHolder.ImageViewHolder;
import com.nftapp.nftmarketplace.R;
import com.nftapp.nftmarketplace.common.Common;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

import java.util.*;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Context mContext;
    private List<Integer> listImages;

//    public ImageAdapter(MainActivity mContext) {
//        this.mContext = mContext;
//        this.listImages = getImages();
//    }
        public ImageAdapter(Context mContext) {
            this.mContext = mContext;
             this.listImages = getImages();
}

    private List<Integer> getImages() {
        List<Integer> results = new ArrayList<>();

        results.add(R.drawable.image2);
        results.add(R.drawable.image3);
        results.add(R.drawable.image6);
        results.add(R.drawable.image8);

        return results;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_images, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(listImages.get(position));
        holder.setImageOnClick(new ImageOnClick() {
            @Override
            public void onClick(int pos) {
                Common.ITEM_SELECTED = " "+position;
                Common.PICTURE_SELECTED = listImages.get(pos);
                mContext.startActivity(new Intent(mContext, PaintActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }
}
