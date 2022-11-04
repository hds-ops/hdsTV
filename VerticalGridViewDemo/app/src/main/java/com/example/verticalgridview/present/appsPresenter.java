package com.example.verticalgridview.present;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.example.verticalgridview.R;

public class appsPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        VerticalPresenter.MyViewHolder myViewHolder = (VerticalPresenter.MyViewHolder) viewHolder;

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

     class MyViewHolder extends Presenter.ViewHolder{

        private TextView textView;
        private ImageView imgView;

        MyViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.text_view);
            imgView = view.findViewById(R.id.image_view);
        }
    }


}
