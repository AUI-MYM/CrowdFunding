package com.example.mym.crowdfunding.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.mym.crowdfunding.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Mert on 7/6/2016.
 */
public class GalleryImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Bitmap> imageList;


    public GalleryImageAdapter(Context context, ArrayList<Bitmap> images) {
        this.mContext = context;
        this.imageList = images;
    }

    public int getCount() {
        return imageList.size();
    }

    public Object getItem(int position) {
        return imageList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        ImageView imageView = new ImageView(mContext);

        //imageView.setImageResource(R.drawable.placeholder);
        //imageView.setImageResource(mImageUrls[index]);

        imageView.setImageBitmap(imageList.get(index));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
        imageView.setBackgroundResource(R.drawable.placeholder);

        imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }


}
