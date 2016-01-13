package xyz.hanks.huatian.bean;

import java.util.ArrayList;

/**
 * 话题的实体类
 *
 * @author zyh
 * @version 1.0
 */
public class TopicItem {

    private int id;
    private String title;
    private String content;
    private ArrayList<String> images;
    private User user;
    private long createAt;
    private int commentCount;

    public TopicItem(User user, String title, String content, ArrayList<String> images, long createAt,
                     int commentCount) {
        this.title = title;
        this.content = content;
        this.images = images;
        this.user = user;
        this.createAt = createAt;
        this.commentCount = commentCount;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
