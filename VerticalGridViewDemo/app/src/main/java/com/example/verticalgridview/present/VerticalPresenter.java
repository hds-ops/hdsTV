package com.example.verticalgridview.present;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.verticalgridview.Poster;
import com.example.verticalgridview.R;

public class VerticalPresenter extends Presenter {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        Poster poster = (Poster) item;

        myViewHolder.speechTitle.setText(poster.getResources().get(0).getSpeechTitle());
        myViewHolder.title.setText((CharSequence) poster.getResources().get(0).getTitle().get(1));
        Glide.with(myViewHolder.picture.getContext())
                .load(poster.getResources().get(0).getUrl())
                .placeholder(R.drawable.ic_baseline_photo_24)
                .fallback(R.drawable.ic_baseline_photo_24)
                .into(myViewHolder.picture);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    static class MyViewHolder extends Presenter.ViewHolder{
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
