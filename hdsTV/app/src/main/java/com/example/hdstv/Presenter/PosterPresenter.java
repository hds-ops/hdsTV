package com.example.hdstv.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.hdstv.R;
import com.example.hdstv.bean.Poster;
import com.example.hdstv.bean.RecommendData;

public class PosterPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);

        return new ResourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        PosterPresenter.ResourceViewHolder resourceViewHolder = (ResourceViewHolder) viewHolder;
        Poster.Resource resource = (Poster.Resource) item;
        if(item instanceof Poster.Resource){
            Glide.with(resourceViewHolder.imageView.getContext())
                    .load(resource.getUrl())
                    .placeholder(R.drawable.ic_baseline_insert_photo_24)
                    .fallback(R.drawable.ic_baseline_insert_photo_24)
                    .into(resourceViewHolder.imageView);
            resourceViewHolder.speechTitle.setText(resource.getSpeechTitle());
            resourceViewHolder.title.setText((CharSequence) resource.getTitle().get(0));
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    static class ResourceViewHolder extends ViewHolder{

        private ImageView imageView;
        private TextView speechTitle;
        private TextView title;

         ResourceViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.picture);
            speechTitle = view.findViewById(R.id.speech_title);
            title = view.findViewById(R.id.title);
             view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                 @Override
                 public void onFocusChange(View v, boolean hasFocus) {
                     if(hasFocus){
                         v.setScaleX(1.2f);
                         v.setScaleY(1.2f);
                     }else{
                         v.setScaleX(1.0f);
                         v.setScaleY(1.0f);
                     }
                 }
             });

        }
    }
}
