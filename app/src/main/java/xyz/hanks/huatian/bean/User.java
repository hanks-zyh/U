package xyz.hanks.huatian.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用户实体类
 *
 * @author zyh
 * @version 1.1 添加心情字段
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String nick;
    private String avatar;

    private String description;

    private int age;
    private int height;
    private ArrayList<String> album;
    private double latitude;
    private double longitude;

    private String education;
    private String money;

    // 造假数据使用
    public User(String nick, String avatar) {
        this.nick = nick;
        this.avatar = avatar;
    }

    public User(String nick, String avatar, int age, int height, double latitude, double longitude) {
        this.nick = nick;
        this.avatar = avatar;
        this.age = age;
        this.height = height;
        this.album = new ArrayList<String>();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User(String nick, String avatar, int age, int height, double latitude, double longitude,
                String education, String money) {
        this.nick = nick;
        this.avatar = avatar;
        this.age = age;
        this.height = height;
        this.album = new ArrayList<String>();
        this.latitude = latitude;
        this.longitude = longitude;
        this.education = education;
        this.money = money;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<String> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<String> album) {
        this.album = album;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
