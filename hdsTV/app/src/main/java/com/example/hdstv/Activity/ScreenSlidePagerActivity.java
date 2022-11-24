package com.example.hdstv.Activity;


import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hdstv.Presenter.TabViewPresenter;
import com.example.hdstv.R;
import com.example.hdstv.View.TabView;
import com.example.hdstv.fragment.ScreenSlidePageFragment;
import com.example.hdstv.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerActivity extends FragmentActivity {

    private final String TAG = ScreenSlidePagerActivity.class.getSimpleName();

    private TabView tabView;
    private FrameLayout frameLayout;
    ScreenSlidePageFragment screenSlidePageFragment;
    private final String[] TITLES = {"电影","动漫","游戏","综艺","体育"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ConstraintLayout constraintLayout = findViewById(R.id.main_constraint_layout);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        constraintLayout.startAnimation(alphaAnimation);

        tabView = findViewById(R.id.tabView);
        frameLayout = findViewById(R.id.container);
        initView();
        Log.d(TAG, "onCreate: " + tabView.hasFocus());
    }

    private void initView(){
        initTabView();
        screenSlidePageFragment = new ScreenSlidePageFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,screenSlidePageFragment).commitAllowingStateLoss();
        tabView.setOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChildViewHolderSelected(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                super.onChildViewHolderSelected(parent, child, position, subposition);
//                screenSlidePageFragment.notifyData(position);


            }

        });
    }

    private void initTabView(){
        tabView.setHorizontalSpacing(50);
        tabView.setGravity(Gravity.CENTER_VERTICAL);
        TabViewPresenter tabViewPresenter = new TabViewPresenter(this);
        ArrayObjectAdapter objectAdapter = new ArrayObjectAdapter(tabViewPresenter);
        objectAdapter.addAll(0,transformTitles());
        ItemBridgeAdapter bridgeAdapter = new ItemBridgeAdapter(objectAdapter);
        tabView.setAdapter(bridgeAdapter);
        tabView.requestFocus();
        FocusHighlightHelper.setupHeaderItemFocusHighlight(bridgeAdapter);
    }

    private List<String> transformTitles(){
        List<String> titles = new ArrayList<>();
        for(int i=0;i<TITLES.length;i++){
            titles.add(TITLES[i]);
        }
        return titles;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        Log.d(TAG,"KeyCode: "+keyCode+"    action: "+action);
        VerticalGridView verticalGridView = screenSlidePageFragment.getVerticalGridView();
        if(screenSlidePageFragment.getVerticalGridView().getSelectedPosition() == 0
                && keyCode == KeyEvent.KEYCODE_DPAD_UP && action == KeyEvent.ACTION_DOWN){
            Log.d(TAG, "dispatchKeyEvent: " + screenSlidePageFragment.getVerticalGridView().getSelectedPosition());
            tabView.getChildAt(screenSlidePageFragment.curTabPosition).requestFocus();
        }
        if(tabView.hasFocus() && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && action == KeyEvent.ACTION_DOWN){
            View childAt = verticalGridView.getChildAt(0);
            if(childAt != null){
                childAt.requestFocus();
                return true;
            }
            Log.d(TAG, "dispatchKeyEvent: tabView -> first HorizontalGridView");
        }
        Log.d(TAG, "dispatchKeyEvent: selectPosition: " + verticalGridView.getSelectedPosition());


        /*if (verticalGridView.hasFocus()){
            if(verticalGridView.getSelectedPosition() == 0){
                View v= verticalGridView == null ? null : ViewUtils.findTargetView(verticalGridView.getFocusedChild(), HorizontalGridView.class);
                if(v != null){
                    HorizontalGridView focusRow = (HorizontalGridView) v;
                    focusRow.setFocusable(false);
                    focusRow.requestFocus();
                    Log.d(TAG, "dispatchKeyEvent: focusRow's child 0: " + focusRow.getChildAt(0));
                    Log.d(TAG, "dispatchKeyEvent: currentFocus: " + focusRow.findFocus());
//                    if(focusRow.getSelectedPosition() == 0){
//                        v = verticalGridView.getChildAt(1);
//                        HorizontalGridView nextRow = (HorizontalGridView) ViewUtils.findTargetView(v, HorizontalGridView.class);
//                        Log.d(TAG, "dispatchKeyEvent: nextRow: " + nextRow);
//                        if(nextRow != null){
//                            nextRow.getChildAt(0).requestFocus();
//                            return true;
//                        }
//                    }
                }
            }
        }*/


        return super.dispatchKeyEvent(event);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
}
