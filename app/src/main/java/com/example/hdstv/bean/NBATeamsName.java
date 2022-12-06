package com.example.hdstv.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NBATeamsName {

    @SerializedName("resources")
    private List<ResourcesDTO> resources;

    public List<ResourcesDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesDTO> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "NBATeamsName{" +
                "resources=" + resources +
                '}';
    }

    public static class ResourcesDTO {
        @SerializedName("speechTitle")
        private String speechTitle;
        @SerializedName("region")
        private String region;
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

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

}
