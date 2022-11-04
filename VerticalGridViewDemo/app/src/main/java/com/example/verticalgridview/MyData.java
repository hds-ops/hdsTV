package com.example.verticalgridview;

import java.net.URL;

public class MyData {
    private int id;
    private String text;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
