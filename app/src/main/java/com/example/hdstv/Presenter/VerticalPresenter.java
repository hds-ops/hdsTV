package com.example.hdstv.Presenter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.hdstv.R;
import com.example.hdstv.bean.Poster;


public class VerticalPresenter extends Presenter {

    static final String TAG = VerticalPresenter.class.getSimpleName();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        Poster.Resource resource = (Poster.Resource) item;

        myViewHolder.speechTitle.setText(resource.getSpeechTitle());
        myViewHolder.title.setText((CharSequence) resource.getTitle().get(0));
        Glide.with(myViewHolder.picture.getContext())
                .load(resource.getUrl())
                .placeholder(R.drawable.ic_baseline_insert_photo_24)
                .fallback(R.drawable.ic_baseline_insert_photo_24)
                .into(myViewHolder.picture);
        Log.d(TAG, "onBindViewHolder: " + resource.getUrl());

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    static class MyViewHolder extends ViewHolder{
        private TextView speechTitle;
        private TextView title;
        private ImageView picture;

        MyViewHolder(View view){
            super(view);
            speechTitle = view.findViewById(R.id.speech_title);
            picture = view.findViewById(R.id.picture);
            title = view.findViewById(R.id.title);
        }
    }
}
