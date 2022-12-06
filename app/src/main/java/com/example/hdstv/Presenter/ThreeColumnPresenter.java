package com.example.hdstv.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.example.hdstv.R;

public class ThreeColumnPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.three_column_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {

    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }


    static class ViewHolder extends Presenter.ViewHolder{
        private ImageView imgView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            imgView = view.findViewById(R.id.three_item_img);
            textView = view.findViewById(R.id.three_item_text);
        }
    }

}
