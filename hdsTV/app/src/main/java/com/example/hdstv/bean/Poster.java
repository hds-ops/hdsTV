package com.example.hdstv.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Poster {

    ArrayList<Resource> resources;
    public static class Resource{

        private  String speechTitle;
        ArrayList<String> title;
        private String url;
        private String vid;



        public String getSpeechTitle() {
            return speechTitle;
        }

        public void setSpeechTitle(String speechTitle) {
            this.speechTitle = speechTitle;
        }

        public ArrayList<String> getTitle() {
            return title;
        }

        public void setTitle(ArrayList<String> title) {
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
            return "Resources{" +

                    "speechTitle='" + speechTitle + '\'' +
                    ", title=" + title +
                    ", url='" + url + '\'' +
                    ", vid='" + vid + '\'' +
                    '}';
        }
    }


    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Poster{" +

                " resources=" + resources +
                '}';
    }
}
