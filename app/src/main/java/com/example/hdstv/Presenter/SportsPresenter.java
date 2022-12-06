package com.example.hdstv.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.hdstv.R;
import com.example.hdstv.View.RoundImageView;
import com.example.hdstv.bean.NBATeamsName;

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
        NBATeamsName.ResourcesDTO sportData = (NBATeamsName.ResourcesDTO) item;
        sportsViewHolder.teamName.setText(sportData.getSpeechTitle());
        sportsViewHolder.teamTitle.setText(sportData.getTitle().get(0));
        Glide.with(sportsViewHolder.teamLogo.getContext())
                .load(sportData.getUrl())
                .placeholder(R.drawable.ic_baseline_insert_photo_24)
                .fallback(R.drawable.ic_baseline_insert_photo_24)
                .into(sportsViewHolder.teamLogo);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    private static class SportsViewHolder extends ViewHolder{

        private ImageView teamLogo;
        private TextView teamName;
        private TextView teamTitle;
        public SportsViewHolder(View view) {
            super(view);
            teamLogo = view.findViewById(R.id.nba_logo);
            teamName = view.findViewById(R.id.nba_speech_title);
            teamTitle = view.findViewById(R.id.title);

            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    float scale;
                    scale = hasFocus ? 1.1f : 1.0f;
                    v.animate().scaleX(scale).scaleY(scale).setInterpolator(new AnticipateInterpolator()).setDuration(200);
                }
            });

        }
    }
}
