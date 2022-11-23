package com.example.hdstv.bean;


import androidx.leanback.widget.HeaderItem;

public class AppHeaderItem extends HeaderItem {

    private boolean isShowMenu = false;
    private boolean isSelect = false;
    private int mAppCount;

    public AppHeaderItem(long id, String name) {
        super(id, name);
    }

    public AppHeaderItem(String name) {
        super(name);
    }

    public boolean isShowMenu() {
        return isShowMenu;
    }

    public void setShowMenu(boolean showMenu) {
        isShowMenu = showMenu;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getAppCount() {
        return mAppCount;
    }

    public void setAppCount(int mAppCount) {
        this.mAppCount = mAppCount;
    }
}
