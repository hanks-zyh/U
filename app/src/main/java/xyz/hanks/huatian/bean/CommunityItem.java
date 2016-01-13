package xyz.hanks.huatian.bean;

import java.io.Serializable;

/**
 * 社区中list的item实体类
 *
 * @author zyh
 * @version 1.0
 */
public class CommunityItem implements Serializable {

    private int people;
    private int topicCount;
    private String title;
    private String description;
    private int id;

    public CommunityItem(int people, int topicCount, String title, String description) {
        this.people = people;
        this.topicCount = topicCount;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
