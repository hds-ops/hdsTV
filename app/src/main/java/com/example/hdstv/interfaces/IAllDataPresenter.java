package com.example.hdstv.interfaces;

import java.util.List;

public interface IAllDataPresenter<T> {
    void initData();
    List<T> getData();
}
