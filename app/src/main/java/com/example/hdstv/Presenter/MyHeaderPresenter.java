package com.example.hdstv.Presenter;


import com.example.hdstv.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;

import com.example.hdstv.bean.AppHeaderItem;
import com.example.hdstv.display.DisplayMode;
import com.example.hdstv.display.IDisplay;

public class MyHeaderPresenter extends RowHeaderPresenter implements IDisplay {

    private Context mContext;
    private ViewHolder mMenuHolder;
    private int mDisplayMode = DisplayMode.NORMAL;

    public MyHeaderPresenter(Context context){
        mContext = context;
        setNullItemVisibilityGone(true);
    }

    @Override
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_item, parent,false);
        MyHeaderPresenter.ViewHolder viewHolder = new MyHeaderPresenter.ViewHolder(view, mContext);
        setSelectLevel(viewHolder, 0);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        HeaderItem headerItem = item == null ? null : ((Row) item).getHeaderItem();
        MyHeaderPresenter.ViewHolder vh = (MyHeaderPresenter.ViewHolder)viewHolder;
        vh.onBind(headerItem, this);
    }

    @Override
    public void setDisplayMode(int mode) {

    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        MyHeaderPresenter.ViewHolder vh = (ViewHolder) viewHolder;
        vh.unbind();
    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder holder) {
        MyHeaderPresenter.ViewHolder vh = (ViewHolder) holder;
        if (vh.mHeaderItem != null && vh.mTitleView != null) {
            vh.bindSelect();
        }
    }

    public static class ViewHolder extends RowHeaderPresenter.ViewHolder {
        Context mContext;
        MyHeaderPresenter mPresenter;
        TextView mTitleView;
        HeaderItem mHeaderItem;

        public ViewHolder(View view, Context context){
            super(view);
            mContext = context;
            mTitleView = view.findViewById(R.id.header_title);
        }

        public void onBind(HeaderItem headerItem, MyHeaderPresenter myHeaderPresenter) {
            mHeaderItem = headerItem;
            mPresenter = myHeaderPresenter;
            view.setTag(false);
            if(mHeaderItem == null){
                if(mTitleView != null){
                    mTitleView.setText(null);
                }

                if(mPresenter.isNullItemVisibilityGone()){
                    view.setVisibility(View.GONE);
                }
            }else {
                if(mTitleView != null){
                    mTitleView.setText(mHeaderItem.getName());
                    bindSelect();
                }
                view.setVisibility(View.VISIBLE);
            }


        }

        public void bindSelect() {
            if (mHeaderItem == null) {
                return;
            }
            boolean isSelect = false;
            if (mHeaderItem instanceof AppHeaderItem) {
                isSelect = ((AppHeaderItem) mHeaderItem).isSelect();
            }

            if (isSelect) {
                mTitleView.setTextColor(mContext.getResources().getColor(R.color.white));
            } else {
                mTitleView.setTextColor(mContext.getResources().getColor(R.color.white));
            }


        }

        public void unbind() {
            if (mTitleView != null) {
                mTitleView.setText(null);
            }
        }


    }
}
