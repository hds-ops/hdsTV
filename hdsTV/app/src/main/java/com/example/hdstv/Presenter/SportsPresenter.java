package com.example.hdstv.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.example.hdstv.R;
import com.example.hdstv.View.RoundImageView;

import java.util.zip.Inflater;

public class SportsPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nba_logo_item, parent, false);
        return new SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        SportsViewHolder sportsViewHolder = (SportsViewHolder) viewHolder;

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    private static class SportsViewHolder extends ViewHolder{

        private RoundImageView teamLogo;
        private TextView teamName;
        public SportsViewHolder(View view) {
            super(view);
            teamLogo = view.findViewById(R.id.logo_img);
            teamName = view.findViewById(R.id.logo_text);

        }
    }
}
