package com.example.scrollview;

public class ContactModel {

    String fullname;
    int avatarResource;
    boolean isSelected;

    //isSelected ko cần truyền vào mà để mặc định là false trong constructor
    public ContactModel(String fullname, int avatarResource) {
        this.fullname = fullname;
        this.avatarResource = avatarResource;
        this.isSelected=false;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
