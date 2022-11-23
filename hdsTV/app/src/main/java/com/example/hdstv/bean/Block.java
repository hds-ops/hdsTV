package com.example.hdstv.bean;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.PresenterSelector;

import java.util.ArrayList;
import java.util.List;

public class Block<T> {

    private static final String TAG = Block.class.getSimpleName();
    private static final int COL_NUM = 7;

    private HeaderItem headerItem;
    private List<ListRow> rows;
    private List<T> data;
    private int colNum;
    private boolean isSelect = false;

    public Block(String title, List<T> data){
        this(title,data,COL_NUM);
    }

    public Block(String title, List<T> data, int colNum){
        rows = new ArrayList<>();
        if(title != null){
            headerItem = new HeaderItem(title);
        }else{
            headerItem  =null;
        }
        if(data == null){
            data = new ArrayList<>();
        }
        this.data = data;
        this.colNum = colNum;
    }

    public void createRows(PresenterSelector selector){
        rows.clear();
        int rowsNum = getRowsNum(colNum,data.size());
        for (int i = 0; i < rowsNum; i++) {
            ArrayObjectAdapter appsAdapter = new ArrayObjectAdapter(selector);

            int startIndex = colNum * i;
            int endIndex = (i + 1 == rowsNum) ? data.size() : colNum*(i+1);
            appsAdapter.addAll(0,data.subList(startIndex,endIndex));
            ListRow appsRow = new ListRow(headerItem, appsAdapter);

            rows.add(appsRow);
        }
    }


    public int getRowsNum() {
        return getRowsNum(colNum, data.size());
    }

    private int getRowsNum(int colNum, int size) {
        return size / colNum + (size % colNum == 0 ? 0 : 1);
    }

    public List<ListRow> getRows() {
        return rows;
    }




    public void addData(T d) {
        data.add(0, d);
    }

    public void remove(T info) {
        data.remove(info);
    }

    public List<T> getData() {
        return data;
    }



    public boolean isSelect() {
        return isSelect;
    }

    public boolean contains(T d) {
        return data.contains(d);
    }

    public String getTitle() {
        return headerItem == null ? "" : headerItem.getName();
    }


}
