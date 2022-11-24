package com.example.horizontalgridviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;

public class HorizontalPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        ViewHolder holder = (ViewHolder) viewHolder;
        Data data = (Data) item;
        holder.title.setText((CharSequence) data.getSpeechTitle());
        Glide.with(holder.img.getContext())
                .load(((Data) item).getUrl())
                .placeholder(R.drawable.ic_baseline_image_24)
                .fallback(R.drawable.ic_baseline_image_24)
                .into(holder.img);
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }


    class ViewHolder extends Presenter.ViewHolder{

         private TextView title;
         private ImageView img;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.speech_title);
            img = view.findViewById(R.id.picture);
        }
    }
}
