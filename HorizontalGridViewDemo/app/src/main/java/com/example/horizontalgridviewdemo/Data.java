package com.example.horizontalgridviewdemo;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {

    @SerializedName("speechTitle")
    private String speechTitle;
    @SerializedName("title")
    private List<String> title;
    @SerializedName("url")
    private String url;
    @SerializedName("vid")
    private String vid;

    public String getSpeechTitle() {
        return speechTitle;
    }

    public void setSpeechTitle(String speechTitle) {
        this.speechTitle = speechTitle;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Data{" +
                "speechTitle='" + speechTitle + '\'' +
                ", title=" + title +
                ", url='" + url + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }
}
