package xyz.hanks.huatian.bean;

import java.util.ArrayList;

/**
 * 首页 "活动" 的实体类
 *
 * @author zyh
 * @version 1.0
 */
public class ActivityItem {

    private User user;
    private String topic;
    private String topicType;
    private String payType;
    private String time;
    private String location;
    private String detail;
    private ArrayList<User> enrollPeople;
    private long createTime;

    public ActivityItem(User user, String topic, String topicType, String payType, String time,
                        String location, String detail) {
        this.user = user;
        this.topic = topic;
        this.topicType = topicType;
        this.payType = payType;
        this.time = time;
        this.location = location;
        this.detail = detail;
        setCreateTime(System.currentTimeMillis());
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ArrayList<User> getEnrollPeople() {
        return enrollPeople;
    }

    public void setEnrollPeople(ArrayList<User> enrollPeople) {
        this.enrollPeople = enrollPeople;
    }

}
