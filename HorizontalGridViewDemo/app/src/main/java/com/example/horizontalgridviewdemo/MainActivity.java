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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private HorizontalGridView horizontalGridView;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData(){
        String dataJson = StringUtils.readAssetsFile("data.json",this);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Data>>(){}.getType();
        dataList = gson.fromJson(dataJson,type);

        Log.d(TAG, "initData: " + dataList.toString());
    }

    private void initView(){
        horizontalGridView = findViewById(R.id.horizontal_grid_view);
        horizontalGridView.setHorizontalSpacing(100);
        horizontalGridView.setVerticalSpacing(30);
        horizontalGridView.setNumRows(6);
        HorizontalPresenter presenter = new HorizontalPresenter();
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(presenter);
        adapter.addAll(0, dataList);
        ItemBridgeAdapter itemBridgeAdapter = new ItemBridgeAdapter(adapter);
        horizontalGridView.setAdapter(itemBridgeAdapter);
    }

}