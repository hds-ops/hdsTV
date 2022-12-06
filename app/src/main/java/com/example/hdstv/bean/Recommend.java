package com.example.hdstv.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class Recommend {


    @SerializedName("resources")
    private List<ResourcesDTO> resources;

    public List<ResourcesDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesDTO> resources) {
        this.resources = resources;
    }

    public static class ResourcesDTO {
        @SerializedName("res_id")
        private Integer resId;
        @SerializedName("url")
        private String url;
        @SerializedName("speech_title")
        private String speechTitle;
        @SerializedName("statis_title")
        private String statisTitle;

        public Integer getResId() {
            return resId;
        }

        public void setResId(Integer resId) {
            this.resId = resId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSpeechTitle() {
            return speechTitle;
        }

        public void setSpeechTitle(String speechTitle) {
            this.speechTitle = speechTitle;
        }

        public String getStatisTitle() {
            return statisTitle;
        }

        public void setStatisTitle(String statisTitle) {
            this.statisTitle = statisTitle;
        }

        @Override
        public String toString() {
            return "ResourcesDTO{" +
                    "resId=" + resId +
                    ", url='" + url + '\'' +
                    ", speechTitle='" + speechTitle + '\'' +
                    ", statisTitle='" + statisTitle + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "resources=" + resources +
                '}';
    }
}
