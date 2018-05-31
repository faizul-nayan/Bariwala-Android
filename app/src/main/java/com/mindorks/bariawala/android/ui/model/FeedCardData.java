package com.mindorks.bariawala.android.ui.model;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public class FeedCardData {

    private int photoId;
    private String title;
    private double price;
    private String location;
    private String time;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FeedCardData{" +
                "photoId=" + photoId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
