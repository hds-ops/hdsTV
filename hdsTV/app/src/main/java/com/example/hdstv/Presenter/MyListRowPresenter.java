package com.example.hdstv.Presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.RowPresenter;

import com.example.hdstv.bean.RowConfig;

import java.util.HashMap;

public class MyListRowPresenter extends ListRowPresenter {

    private static final String TAG = MyListRowPresenter.class.getSimpleName();
    private final HashMap<Class<?>, RowConfig> mClassMap = new HashMap<>();

    private OnRowAttachToWindowListener mRowAttachListener;

    public MyListRowPresenter(){
        super(FocusHighlight.ZOOM_FACTOR_NONE);
        enableChildRoundedCorners(false);
    }
    public void addRowConfig(Class<?> cls, RowConfig config){
        mClassMap.put(cls,config);
    }


    @SuppressLint("RestrictedApi")
    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        super.onBindRowViewHolder(holder, item);
        HorizontalGridView itemRecyclerView = ((ListRowPresenter.ViewHolder)holder).getGridView();
        itemRecyclerView.setFocusDrawingOrderEnabled(true);

        itemRecyclerView.setFocusScrollStrategy(BaseGridView.FOCUS_SCROLL_ITEM);

        //根据item类型添加不同的间距类型
        RowConfig config = getRowConfig(item);
        Log.d(TAG, "onBindRowViewHolder: config = [" + config + "], item = [" + item + "]");
        if (config != null){
            if(config.numCols != 0){
                int numRows = calculateRows(item, config.numCols);
                itemRecyclerView.setNumRows(numRows);
            }
            if (config.margin != null){
                itemRecyclerView.setHorizontalSpacing(config.margin.marginHorizontal);
                itemRecyclerView.setVerticalSpacing(config.margin.marginVertical);

                itemRecyclerView.setPadding(config.paddingHorizon, 0, config.paddingHorizon, 0);
            }
        }
    }

    @Override
    protected void onUnbindRowViewHolder(RowPresenter.ViewHolder holder) {
        super.onUnbindRowViewHolder(holder);
    }

    @Override
    protected void onRowViewAttachedToWindow(RowPresenter.ViewHolder vh) {
        super.onRowViewAttachedToWindow(vh);
        if(mRowAttachListener != null){
            mRowAttachListener.OnRowAttachToWindow(vh);
        }
    }

    private RowConfig getRowConfig(Object item){
        if(item instanceof ListRow){
            ObjectAdapter adapter = ((ListRow) item).getAdapter();
            if(adapter.size() > 0){
                Class<?> cls = adapter.get(0).getClass();
                return mClassMap.get(cls);
            }
        }
        return null;
    }

    private int calculateRows(Object item, int numCols){
        if (item instanceof ListRow && numCols != 0){
            ObjectAdapter adapter = ((ListRow) item).getAdapter();
            int size = adapter.size();
            Log.d(TAG, "calculateRows: " + (size / numCols) + " + " + (size % numCols == 0 ? 0 :1));
            return size/numCols+(size%numCols == 0?0:1);
        }
        return 0;
    }

    public interface OnRowAttachToWindowListener{
        void OnRowAttachToWindow(RowPresenter.ViewHolder holder);
    }

    public void setOnRowAttachToWindowListener(OnRowAttachToWindowListener listener) {
        mRowAttachListener = listener;
    }
}
