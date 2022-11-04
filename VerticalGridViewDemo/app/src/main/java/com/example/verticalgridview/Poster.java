package com.example.verticalgridview;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Poster {
    private int blockType;
    private int displayType;
    private int id;
    @SerializedName("recommendtype")
    private String recommendType;
    ArrayList<Resources> resources;
    public static class Resources{
        class ActionUrl{
            String action;
            String behavior;
            ArrayList <Extra_map> extra_map;
            class Extra_map{
                private String key;
                private String type;
                private String value;
            }
            @Override
            public String toString() {
                return "ActionUrl{" +
                        "action='" + action + '\'' +
                        ", behavior='" + behavior + '\'' +
                        ", extra_map=" + extra_map +
                        '}';
            }
        }
        private  int busType;
        class DefaultActionUrl{}
        private  String licenceId;
        private  int recoColld;
        private  String reportStr;
        private  int resId;
        private  int resOrigin;
        private  String speechTitle;
        ArrayList<String> title;
        private String url;
        private String vid;

        public int getBusType() {
            return busType;
        }

        public void setBusType(int busType) {
            this.busType = busType;
        }

        public String getLicenceId() {
            return licenceId;
        }

        public void setLicenceId(String licenceId) {
            this.licenceId = licenceId;
        }

        public int getRecoColld() {
            return recoColld;
        }

        public void setRecoColld(int recoColld) {
            this.recoColld = recoColld;
        }

        public String getReportStr() {
            return reportStr;
        }

        public void setReportStr(String reportStr) {
            this.reportStr = reportStr;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public int getResOrigin() {
            return resOrigin;
        }

        public void setResOrigin(int resOrigin) {
            this.resOrigin = resOrigin;
        }

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
                    "busType=" + busType +
                    ", licenceId='" + licenceId + '\'' +
                    ", recoColld=" + recoColld +
                    ", reportStr='" + reportStr + '\'' +
                    ", resId=" + resId +
                    ", resOrigin=" + resOrigin +
                    ", speechTitle='" + speechTitle + '\'' +
                    ", title=" + title +
                    ", url='" + url + '\'' +
                    ", vid='" + vid + '\'' +
                    '}';
        }
    }

    public int getBlockType() {
        return blockType;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public int getDisplayType() {
        return displayType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(String recommendType) {
        this.recommendType = recommendType;
    }

    public ArrayList<Resources> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resources> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "blockType=" + blockType +
                ", displayType=" + displayType +
                ", id=" + id +
                ", recommendType='" + recommendType + '\'' +
                ", resources=" + resources +
                '}';
    }
}
