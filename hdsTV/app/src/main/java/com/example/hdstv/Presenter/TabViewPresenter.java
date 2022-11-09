package com.example.hdstv.Presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.example.hdstv.R;

public class TabViewPresenter extends Presenter {

    private Context context;

    public TabViewPresenter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_view_item, parent, false);
        return new TabViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        String titleText = (String) item;
        TabViewHolder tabViewHolder = (TabViewHolder) viewHolder;
        tabViewHolder.titleText.setText(titleText);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }


    public class TabViewHolder extends Presenter.ViewHolder{
        private TextView titleText;
        TabViewHolder(View view){
            super(view);
            titleText = view.findViewById(R.id.tabView_text);
            initView();
        }

        private void initView(){
            titleText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    titleText.setBackground(hasFocus ? context.getResources().getDrawable(R.drawable.round_button): null);
                    titleText.setTextColor(hasFocus ? context.getResources().getColor(R.color.black) : context.getResources().getColor(R.color.white));
                }
            });


        }
    }
}
