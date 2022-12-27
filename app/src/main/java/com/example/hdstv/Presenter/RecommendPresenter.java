package com.example.hdstv.Presenter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.hdstv.R;
import com.example.hdstv.bean.Recommend;
import com.example.hdstv.listener.ItemClickable;

public class RecommendPresenter extends Presenter implements ItemClickable {

    private static final String TAG = RecommendPresenter.class.getSimpleName();

    private Context mContext;
    private OnItemViewClickedListener mItemClickedListener;

    public RecommendPresenter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item,parent,false);
        RecommendViewHolder holder = new RecommendViewHolder(view);
        if(mItemClickedListener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickedListener.onItemClicked(holder, holder.data, null, null);
                }
            });

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        RecommendViewHolder recommendViewHolder = (RecommendViewHolder) viewHolder;
        Recommend.ResourcesDTO recommendData = (Recommend.ResourcesDTO) item;
        if(item instanceof Recommend.ResourcesDTO){
            recommendViewHolder.data = (Recommend.ResourcesDTO) item;
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

    @Override
    public void setOnItemClickListener(OnItemViewClickedListener itemClickListener) {
        mItemClickedListener = itemClickListener;
    }

    static class RecommendViewHolder extends ViewHolder{

        private ImageView imageView;
        private TextView speechTitle;
        private TextView title;
        private Recommend.ResourcesDTO data;

        public RecommendViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.recommend_picture);
            speechTitle = view.findViewById(R.id.recommend_speech_title);
            title = view.findViewById(R.id.recommend_title);
            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    float scale = hasFocus ? 1.1f : 1.0f;
                    v.animate().scaleX(scale).scaleY(scale).setInterpolator(new AnticipateInterpolator()).setDuration(300);
                }
            });
        }

//        public void onBind(Object item){
//            if(item instanceof Recommend.ResourcesDTO){
//                this.data = (Recommend.ResourcesDTO) item;
//            }
//        }
    }
}
