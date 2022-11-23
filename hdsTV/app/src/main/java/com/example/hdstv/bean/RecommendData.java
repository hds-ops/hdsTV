package com.example.hdstv.bean;

public class RecommendData {
    private int recommendId;
    private String speechTitle;
    private String title;
    private String url;

    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }

    public String getSpeechTitle() {
        return speechTitle;
    }

    public void setSpeechTitle(String speechTitle) {
        this.speechTitle = speechTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RecommendData{" +
                "recommendId=" + recommendId +
                ", speechTitle='" + speechTitle + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
