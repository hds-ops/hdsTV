package com.example.horizontalgridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private HorizontalGridView horizontalGridView;
    private List<Integer> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        horizontalGridView = findViewById(R.id.horizontal_grid_view);
        horizontalGridView.setNumRows(3);
        horizontalGridView.setHorizontalSpacing(20);
        horizontalGridView.setGravity(Gravity.CENTER_VERTICAL);

        horizontalGridView.setOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
            @Override
            public void onChildViewHolderSelected(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                super.onChildViewHolderSelected(parent, child, position, subposition);
                Log.d(TAG, "onChildViewHolderSelected() returned " + position);
            }


            @Override
            public void onChildViewHolderSelectedAndPositioned(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                super.onChildViewHolderSelectedAndPositioned(parent, child, position, subposition);
                Log.d(TAG, "onChildViewHolderSelectedAndPositioned() returned: " + position);
            }
        });
        HorizontalPresenter myPresenter = new HorizontalPresenter();
        ArrayObjectAdapter objectAdapter = new ArrayObjectAdapter(myPresenter);
        initData();
        objectAdapter.addAll(0,mDataList);
        ItemBridgeAdapter bridgeAdapter = new ItemBridgeAdapter(objectAdapter);
        horizontalGridView.setAdapter(bridgeAdapter);
        horizontalGridView.requestFocus();
        FocusHighlightHelper.setupHeaderItemFocusHighlight(bridgeAdapter);
    }

    private void initData(){
        if (mDataList == null){
            mDataList = new ArrayList<>();
            for(int i = 0;i < 100;i++){
                mDataList.add(i);
            }
        }
    }
}