package com.example.hdstv.Presenter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.hdstv.R;
import com.example.hdstv.bean.Poster;
import com.example.hdstv.bean.Recommend;
import com.example.hdstv.bean.RecommendData;

public class RecommendPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item,parent,false);

        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        RecommendViewHolder recommendViewHolder = (RecommendViewHolder) viewHolder;
        Recommend.ResourcesDTO recommendData = (Recommend.ResourcesDTO) item;
        if(item instanceof Recommend.ResourcesDTO){
        Glide.with(recommendViewHolder.imageView.getContext())
                    .load(recommendData.getUrl())
                    .placeholder(R.drawable.ic_baseline_insert_photo_24)
                    .fallback(R.drawable.ic_baseline_insert_photo_24)
                    .into(recommendViewHolder.imageView);
        recommendViewHolder.speechTitle.setText(recommendData.getSpeechTitle());
        recommendViewHolder.title.setText((CharSequence) recommendData.getStatisTitle());
        }

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    static class RecommendViewHolder extends ViewHolder{

        private ImageView imageView;
        private TextView speechTitle;
        private TextView title;

        public RecommendViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.recommend_picture);
            speechTitle = view.findViewById(R.id.recommend_speech_title);
            title = view.findViewById(R.id.recommend_title);


        }
    }
}
