package com.example.scrollview;

public class ItemModel {
    String lable;
    int thumbnailResource;//ảnh nhỏ thumbnail
    int imageResource;//ảnh to wall


    public ItemModel(String lable, int thumbnailResource, int imageResource) {
        this.lable = lable;
        this.thumbnailResource = thumbnailResource;
        this.imageResource = imageResource;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getThumbnailResource() {
        return thumbnailResource;
    }

    public void setThumbnailResource(int thumbnailResource) {
        this.thumbnailResource = thumbnailResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
