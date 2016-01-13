package xyz.hanks.huatian.bean;

import java.util.ArrayList;

public class EncounterItem {

    private User user;
    private String content;
    private ArrayList<String> newPhoto;

    public EncounterItem(User user, String content, ArrayList<String> newPhoto) {
        this.user = user;
        this.content = content;
        this.newPhoto = newPhoto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getNewPhoto() {
        return newPhoto;
    }

    public void setNewPhoto(ArrayList<String> newPhoto) {
        this.newPhoto = newPhoto;
    }

}
